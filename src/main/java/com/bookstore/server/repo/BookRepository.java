package com.bookstore.server.repo;

import com.bookstore.server.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sashika.Udana
 * on 27/Feb/2023
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
