package com.example.myprojectspringboot.controllers;

import com.example.myprojectspringboot.dto.AuthorDto;
import com.example.myprojectspringboot.entities.AuthorEntity;
import com.example.myprojectspringboot.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
