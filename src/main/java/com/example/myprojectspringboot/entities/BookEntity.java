package com.example.myprojectspringboot.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "public", catalog = "lesson5DB")
public class BookEntity {
    private int id;
    private String title;
    private String description;
    private Integer pageQty;
    private AuthorEntity authorEntity;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "page_qty", nullable = true)
    public Integer getPageQty() {
        return pageQty;
    }

    public void setPageQty(Integer pageQty) {
        this.pageQty = pageQty;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(pageQty, that.pageQty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, pageQty);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pageQty=" + pageQty +
                ", authorEntity=" + authorEntity.getId() +
                '}';
    }
}
