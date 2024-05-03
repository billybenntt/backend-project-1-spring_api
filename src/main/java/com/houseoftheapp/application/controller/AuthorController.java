package com.houseoftheapp.application.controller;


import com.houseoftheapp.application.model.entity.Author;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {


    @PostMapping(path = "/authors")
    public Author createAuthor(@RequestBody Author author) {
        return author;
    }

}
