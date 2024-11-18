package com.cse.library.Service;
// BookService.java

import com.cse.library.Model.Book;
import com.cse.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private QueryRepository queryRepository;

    // Add a new book
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Fetch all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Fetch all user queries
    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }
}

