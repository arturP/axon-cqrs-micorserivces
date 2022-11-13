package io.artur.microservices.books.command.rest;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBookRestModel {
    @NotBlank(message = "Title is required field")
    private String title;
    @NotBlank(message = "Author is required field")
    private String author;
    @NotBlank(message = "Publisher is required field")
    private String publisher;
    @NotBlank(message = "Isbn is required field")
    private String isbn;
}
