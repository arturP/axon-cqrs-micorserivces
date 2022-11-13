package io.artur.microservices.books.core.data;


import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<BookEntity, String> {

    BookEntity findByBookId(String bookId);
    BookEntity findByBookIdOrTitle(String bookId, String title);
}
