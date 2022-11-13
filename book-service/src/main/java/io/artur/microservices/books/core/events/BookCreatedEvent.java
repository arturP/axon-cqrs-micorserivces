package io.artur.microservices.books.core.events;

import lombok.Data;

@Data
public class BookCreatedEvent {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
