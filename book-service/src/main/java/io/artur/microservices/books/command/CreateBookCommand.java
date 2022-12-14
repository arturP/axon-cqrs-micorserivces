package io.artur.microservices.books.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateBookCommand {
    @TargetAggregateIdentifier
    private final String bookId;
    private final String title;
    private final String author;
    private final String publisher;
    private final String isbn;
}
