package com.bookstore.server.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sashika.Udana
 * on 28/Feb/2023
 */
@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private String id;
    private String name;
    private String isbn;
    private BigDecimal price;
    private List<String> authors = new ArrayList<>();
}
