package io.artur.microservices.books.command;

import io.artur.microservices.books.core.events.BookCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
public class BookAggregate {

    @AggregateIdentifier
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private String isbn;

    @CommandHandler
    public BookAggregate(CreateBookCommand command) {
        validateCreateCommand(command);
        BookCreatedEvent event = new BookCreatedEvent();

        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BookCreatedEvent bookCreatedEvent) {
        this.bookId = bookCreatedEvent.getBookId();
        this.author = bookCreatedEvent.getAuthor();
        this.title = bookCreatedEvent.getTitle();
        this.isbn = bookCreatedEvent.getIsbn();
        this.publisher = bookCreatedEvent.getPublisher();
    }

    private void validateCreateCommand(CreateBookCommand command) {
        if (command.getAuthor() == null) {
            throw new IllegalArgumentException("Author field is not set");
        }
        if (command.getTitle() == null) {
            throw new IllegalArgumentException("Title field is not set");
        }
    }
}
