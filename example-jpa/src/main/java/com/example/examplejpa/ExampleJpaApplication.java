package com.example.examplejpa;

import com.example.examplejpa.entity.Author;
import com.example.examplejpa.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ExampleJpaApplication implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExampleJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Author> authorList = authorRepository.findAll();
        for(Author author:authorList){
            System.out.println(author.getName());
            List<Book> bookList = author.getBookList();
            for(Book book:bookList){
                System.out.println(book.getName());
            }
        }
    }
}
