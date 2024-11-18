package com.cse.library.AdminController;
// AdminController.java

import ch.qos.logback.core.model.Model;
import com.cse.library.Model.Book;
import com.cse.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookService bookService;

    @GetMapping("/admin")
    public String showAdminLoginPage() {
        return "adminLogin";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Check credentials (simple hardcoded for now)
        if ("admin".equals(username) && "CSE@Books".equals(password)) {
            return "adminDashboard";
        } else {
            return "adminLogin";
        }
    }

    @PostMapping("/admin/upload")
    public String uploadBook(@RequestParam String title, @RequestParam String author, @RequestParam String imageUrl, @RequestParam String downloadLink) {
        Book newBook = new Book(title, author, imageUrl, downloadLink);
        bookService.saveBook(newBook);
        return "redirect:/books";
    }
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>("Book added successfully!", HttpStatus.CREATED);
    }

    // Endpoint to delete a book by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully!", HttpStatus.OK);
    }

    // Endpoint to fetch all books
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    // Endpoint to fetch all user queries
    @GetMapping("/queries")
    public ResponseEntity<List<Query>> getAllQueries() {
        return new ResponseEntity<>(bookService.getAllQueries(), HttpStatus.OK);
    }
}

}
