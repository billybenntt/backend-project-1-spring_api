package com.houseoftheapp.application.services;

import com.houseoftheapp.application.model.entity.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    AuthorEntity save(AuthorEntity authorEntity);

    AuthorEntity createAuthor(AuthorEntity author);
}
