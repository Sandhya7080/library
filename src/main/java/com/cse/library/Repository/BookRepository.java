package com.cse.library.Repository;
// BookRepository.java
import com.cse.library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom methods can be added here if needed
}
