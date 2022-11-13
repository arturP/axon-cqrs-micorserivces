package io.artur.microservices.books.query.rest;


import io.artur.microservices.books.query.FindBooksQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public List<BookRestModel> getBooks() {
        FindBooksQuery findBooksQuery = new FindBooksQuery();
        return queryGateway.query(findBooksQuery,
                ResponseTypes.multipleInstancesOf(BookRestModel.class)).join();
    }
}
