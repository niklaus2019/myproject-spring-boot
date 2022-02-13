package com.example.myprojectspringboot.services;

import com.example.myprojectspringboot.dto.AuthorDto;
import com.example.myprojectspringboot.entities.AuthorEntity;
import com.example.myprojectspringboot.repo.AuthorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<AuthorDto> getAllAuthors() {
        ModelMapper modelMapper = new ModelMapper();
        List<AuthorEntity>  allAuthors = authorRepo.getAllAuthors();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for(AuthorEntity authorEntity : allAuthors) {
           authorDtos.add(modelMapper.map(authorEntity,AuthorDto.class));
        }
        return authorDtos;
    }

    public List<AuthorEntity> getAuthorsByName(String name) {
        return authorRepo.getAllAuthors().stream().filter(a -> a.getName() == name).collect(Collectors.toList());
    }
}
