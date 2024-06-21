package com.houseoftheapp.application.services.Impl;

import com.houseoftheapp.application.model.entity.AuthorEntity;
import com.houseoftheapp.application.repository.AuthorRepository;
import com.houseoftheapp.application.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return null;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
