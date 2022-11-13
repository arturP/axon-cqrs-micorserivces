package io.artur.microservices.books.query;

import io.artur.microservices.books.core.data.BookEntity;
import io.artur.microservices.books.core.data.BooksRepository;
import io.artur.microservices.books.query.rest.BookRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BooksQueryHandler {

    private final BooksRepository booksRepository;

    @QueryHandler
    public List<BookRestModel> findBooks(FindBooksQuery query) {
        List<BookRestModel> booksRest = new ArrayList<>();
        List<BookEntity> bookEntities = booksRepository.findAll();
        bookEntities.forEach(entity -> {
            BookRestModel bookRestModel = new BookRestModel();
            BeanUtils.copyProperties(entity, bookRestModel);
            booksRest.add(bookRestModel);
        });
        return booksRest;
    }
}
