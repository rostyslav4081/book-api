package com.example.bookapi.controller;

import com.example.bookapi.exception.ResourceNotFoundException;
import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books" )
@CrossOrigin(origins = "http://allowed-origin.com", maxAge = 3600) // Вказуємо дозволене походження та максимальний вік для кешу CORS
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws URISyntaxException {
       System.out.print(book);
        Book savedBook = bookRepository.save(book);

        return ResponseEntity.created(new URI("/api/books/" + savedBook.getId())).body(savedBook);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        try {
            Book existingBook = bookRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

            existingBook.setName(updatedBook.getName());
            existingBook.setInfoIndexId(updatedBook.getInfoIndexId());
            existingBook.setInfoAuthor(updatedBook.getInfoAuthor());
            existingBook.setInfoCategoryId(updatedBook.getInfoCategoryId());
            existingBook.setInfoCategory(updatedBook.getInfoCategory());
            existingBook.setImgSrc(updatedBook.getImgSrc());
            existingBook.setImgAlt(updatedBook.getImgAlt());

            Book savedBook = bookRepository.save(existingBook);
            return ResponseEntity.ok(savedBook);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}