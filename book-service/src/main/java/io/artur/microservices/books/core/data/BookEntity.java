package io.artur.microservices.books.core.data;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "books")
@Data
public class BookEntity implements Serializable {
    static final long serialVersionUID = -134971915738088248L;
    @Id
    @Column(unique = true)
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
