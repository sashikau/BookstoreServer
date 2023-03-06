CREATE TABLE BookStore.book (
                                id BIGINT auto_increment NOT NULL,
                                name varchar(100) NOT NULL,
                                isbn varchar(15) NOT NULL,
                                price DEC(10,2) NOT NULL,
                                CONSTRAINT Book_PK PRIMARY KEY (id)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE BookStore.author (
                                  id BIGINT auto_increment NOT NULL,
                                  bookId BIGINT NOT NULL,
                                  name varchar(100) NOT NULL,
                                  CONSTRAINT author_PK PRIMARY KEY (id),
                                  CONSTRAINT author_FK FOREIGN KEY (bookId) REFERENCES BookStore.book(id)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
;
