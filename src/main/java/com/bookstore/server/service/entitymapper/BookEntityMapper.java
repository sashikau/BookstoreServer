package com.bookstore.server.service.entitymapper;

import com.bookstore.server.entity.AuthorEntity;
import com.bookstore.server.entity.BookEntity;
import com.bookstore.server.service.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class BookEntityMapper implements EntityMapper<BookEntity, BookDTO> {

    @Override
    public BookEntity toEntity(BookDTO dto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(dto.getIsbn());
        bookEntity.setName(dto.getName());
        bookEntity.setPrice(dto.getPrice());
        Collection<AuthorEntity> authorEntities =  new ArrayList<>();

        for (String author : dto.getAuthors()) {
            AuthorEntity authorEntity = new AuthorEntity();
            authorEntity.setName(author);
            authorEntity.setBookEntity(bookEntity);
            authorEntities.add(authorEntity);
        }

        bookEntity.setAuthorsById(authorEntities);

        return bookEntity;
    }

    @Override
    public BookDTO toDTO(BookEntity entity) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(String.valueOf(entity.getId()));
        bookDTO.setIsbn(entity.getIsbn());
        bookDTO.setName(entity.getName());
        bookDTO.setPrice(entity.getPrice());

        for (AuthorEntity authorEntity : entity.getAuthorsById()) {
            bookDTO.getAuthors().add(authorEntity.getName());
        }

        return bookDTO;
    }
}
