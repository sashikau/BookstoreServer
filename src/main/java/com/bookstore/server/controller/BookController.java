package com.bookstore.server.controller;

import com.bookstore.server.controller.dtomapper.BookDTOMapper;
import com.bookstore.server.service.BookService;
import com.bookstore.server.service.dto.BookDTO;
import com.rest.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sashika.Udana
 * on 27/Feb/2023
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final BookDTOMapper bookDTOMapper;

    public BookController(BookService bookService, BookDTOMapper bookDTOMapper) {
        this.bookService = bookService;
        this.bookDTOMapper = bookDTOMapper;
    }

    @PostMapping
    public Book createUser(@RequestBody Book book) {
        return bookDTOMapper.toRest(bookService.save(bookDTOMapper.toDTO(book)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getById(id);
        if (bookDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bookDTOMapper.toRest(bookDTO));
        }
    }
}
