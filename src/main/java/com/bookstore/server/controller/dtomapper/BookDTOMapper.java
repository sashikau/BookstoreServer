package com.bookstore.server.controller.dtomapper;

import com.bookstore.server.service.dto.BookDTO;
import com.rest.models.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDTOMapper extends DTOMapper<BookDTO, Book> {

}
