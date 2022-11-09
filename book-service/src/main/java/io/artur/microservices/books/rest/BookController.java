package io.artur.microservices.books.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String createBook() {
        return "Http post called";
    }

    @GetMapping
    public String getBook() {
        return "Http get called";
    }
}
