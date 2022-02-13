package com.example.myprojectspringboot.services;
import com.example.myprojectspringboot.dto.AuthorDto;
import com.example.myprojectspringboot.dto.BookDto;
import com.example.myprojectspringboot.entities.AuthorEntity;
import com.example.myprojectspringboot.entities.BookEntity;
import com.example.myprojectspringboot.repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<BookDto> getAllBooks() {
        ModelMapper modelMapper = new ModelMapper();
        List<BookEntity>  allBooks = bookRepo.getAllBooks();
        List<BookDto> bookDtos = new ArrayList<>();
        for(BookEntity bookEntity : allBooks) {
            modelMapper.map(allBooks,BookDto.class);
            bookDtos.add(modelMapper.map(bookEntity,BookDto.class));
        }
        return  bookDtos;
    }

    public List<BookEntity> getBookByTitle(String title) {
        return bookRepo.getAllBooks().stream().filter(b -> b.getTitle() == title).collect(Collectors.toList());
    }
}
