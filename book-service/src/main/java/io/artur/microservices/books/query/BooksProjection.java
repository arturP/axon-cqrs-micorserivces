package io.artur.microservices.books.query;

import io.artur.microservices.books.core.data.BookEntity;
import io.artur.microservices.books.core.data.BooksRepository;
import io.artur.microservices.books.core.events.BookCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BooksProjection {
    private final BooksRepository booksRepository;

    @EventHandler
    public void on(BookCreatedEvent bookCreatedEvent) {
        BookEntity entity = new BookEntity();
        BeanUtils.copyProperties(bookCreatedEvent, entity);
        booksRepository.save(entity);
    }
}
