package com.example.bookapi.model;


import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "info_index_id")
    private String infoIndexId;

    @Column(name = "info_author")
    private String infoAuthor;

    @Column(name = "info_category_id")
    private String infoCategoryId;

    @Column(name = "info_category")
    private String infoCategory;

    @Column(name = "img_src")
    private String imgSrc;

    @Column(name = "img_alt")
    private String imgAlt;

    public Book() {
        // Empty constructor for JPA
    }

    public Book(String name, String infoIndexId, String infoAuthor, String infoCategoryId, String infoCategory, String imgSrc, String imgAlt) {
        this.name = name;
        this.infoIndexId = infoIndexId;
        this.infoAuthor = infoAuthor;
        this.infoCategoryId = infoCategoryId;
        this.infoCategory = infoCategory;
        this.imgSrc = imgSrc;
        this.imgAlt = imgAlt;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfoIndexId() {
        return infoIndexId;
    }

    public void setInfoIndexId(String infoIndexId) {
        this.infoIndexId = infoIndexId;
    }

    public String getInfoAuthor() {
        return infoAuthor;
    }

    public void setInfoAuthor(String infoAuthor) {
        this.infoAuthor = infoAuthor;
    }

    public String getInfoCategoryId() {
        return infoCategoryId;
    }

    public void setInfoCategoryId(String infoCategoryId) {
        this.infoCategoryId = infoCategoryId;
    }

    public String getInfoCategory() {
        return infoCategory;
    }

    public void setInfoCategory(String infoCategory) {
        this.infoCategory = infoCategory;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgAlt() {
        return imgAlt;
    }

    public void setImgAlt(String imgAlt) {
        this.imgAlt = imgAlt;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", infoIndexId='" + infoIndexId + '\'' +
                ", infoAuthor='" + infoAuthor + '\'' +
                ", infoCategoryId='" + infoCategoryId + '\'' +
                ", infoCategory='" + infoCategory + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", imgAlt='" + imgAlt + '\'' +
                '}';
    }
}