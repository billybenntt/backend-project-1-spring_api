package com.houseoftheapp.database.controllers;

import com.houseoftheapp.database.config.MapperConfig;
import com.houseoftheapp.database.domain.dto.AuthorDto;
import com.houseoftheapp.database.domain.entities.AuthorEntity;
import com.houseoftheapp.database.mappers.Mapper;
import com.houseoftheapp.database.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    private final Mapper<AuthorEntity, AuthorDto> authorMapper;
    private final MapperConfig mapperConfig;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper, MapperConfig mapperConfig) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
        this.mapperConfig = mapperConfig;
    }

    // ADD ONE
    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    // GET MANY
    @GetMapping(path = "/authors")
    public List<AuthorDto> listAuthors() {
        List<AuthorEntity> authors = authorService.findAll();

        return authors.stream()
                .map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

    // GET ONE
    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Long id) {

        Optional<AuthorEntity> foundAuthor = authorService.findOne(id);

        return foundAuthor.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }


}
