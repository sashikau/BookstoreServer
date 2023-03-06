package com.bookstore.server.service;

import com.bookstore.server.repo.BookRepository;
import com.bookstore.server.service.dto.BookDTO;
import com.bookstore.server.service.entitymapper.BookEntityMapper;
import org.springframework.stereotype.Service;

/**
 * Created by Sashika.Udana
 * on 28/Feb/2023
 */
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    public BookService(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
        this.bookRepository = bookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    public BookDTO save(BookDTO bookDTO) {
        return bookEntityMapper.toDTO(bookRepository.save(bookEntityMapper.toEntity(bookDTO)));
    }

    public BookDTO getById(Long id) {
        return bookEntityMapper.toDTO(bookRepository.getOne(id));
    }
}
