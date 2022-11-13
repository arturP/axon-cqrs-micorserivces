package io.artur.microservices.books.command.rest;

import io.artur.microservices.books.command.CreateBookCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksCommandController {

    private final CommandGateway commandGateway;

    @PostMapping
    public String createBook(@Valid @RequestBody CreateBookRestModel createBookRestModel) {

        return commandGateway.sendAndWait(CreateBookCommand.builder()
                .bookId(UUID.randomUUID().toString())
                .title(createBookRestModel.getTitle())
                .isbn(createBookRestModel.getIsbn())
                .author(createBookRestModel.getAuthor())
                .publisher(createBookRestModel.getPublisher())
                .build());
    }
}
