package com.example.myprojectspringboot.controllers;
import com.example.myprojectspringboot.dto.BookDto;
import com.example.myprojectspringboot.entities.BookEntity;
import com.example.myprojectspringboot.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }
}
