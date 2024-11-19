package com.cse.library.AdminController;

// Import statements
import com.cse.library.Model.Book;
import com.cse.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin") // Base path for admin endpoints
public class AdminController {

    @Autowired
    private BookService bookService;

    // Admin login page
    @GetMapping
    public String showAdminLoginPage() {
        return "adminLogin";
    }

    // Admin login action
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "CSE@Books".equals(password)) {
            return "adminDashboard";
        } else {
            return "adminLogin";
        }
    }

    // Upload a book
    @PostMapping("/upload")
    public String uploadBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String imageUrl,
            @RequestParam String downloadLink) {

        Book newBook = new Book();
        newBook.setBookName(title);
        newBook.setAuthor(author);
        newBook.setDescription(downloadLink); // Assuming `description` for the download link
        bookService.addBook(newBook);

        return "redirect:/books";
    }

    // Add a book via JSON
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>("Book added successfully!", HttpStatus.CREATED);
    }

    // Delete a book by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully!", HttpStatus.OK);
    }

    // Fetch all books
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    // Fetch all user queries
    @GetMapping("/queries")
    public ResponseEntity<List<?>> getAllQueries() {
        return new ResponseEntity<>(bookService.getAllQueries(), HttpStatus.OK);
    }
}
