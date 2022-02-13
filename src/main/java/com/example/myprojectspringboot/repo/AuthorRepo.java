package com.example.myprojectspringboot.repo;

import com.example.myprojectspringboot.entities.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class AuthorRepo {
    private EntityManager entityManager;

    @Autowired
    public AuthorRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<AuthorEntity> getAllAuthors() {
        Query query = entityManager.createQuery("Select author From AuthorEntity author");
        return query.getResultList();
    }
}
