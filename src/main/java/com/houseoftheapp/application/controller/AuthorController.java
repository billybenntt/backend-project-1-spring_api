package com.houseoftheapp.application.controller;


import com.houseoftheapp.application.mappers.Mapper;
import com.houseoftheapp.application.model.dto.AuthorDTO;
import com.houseoftheapp.application.model.entity.AuthorEntity;
import com.houseoftheapp.application.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final Mapper<AuthorEntity, AuthorDTO> authorMapper;


    @Autowired
    public AuthorController(AuthorService authorService,
                            Mapper<AuthorEntity, AuthorDTO> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }


    @PostMapping(path = "/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO author) {

        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);

        return authorMapper.mapTo(savedAuthorEntity);
    }

}
