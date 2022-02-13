package com.example.myprojectspringboot.repo;

import com.example.myprojectspringboot.entities.AuthorEntity;
import com.example.myprojectspringboot.entities.BookEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class BookRepo {
    private EntityManager entityManager;

    public BookRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<BookEntity> getAllBooks() {
        Query query = entityManager.createQuery("Select book From BookEntity book");
        return query.getResultList();
    }
}
