package io.artur.microservices.books.query.rest;

import lombok.Data;

@Data
public class BookRestModel {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
