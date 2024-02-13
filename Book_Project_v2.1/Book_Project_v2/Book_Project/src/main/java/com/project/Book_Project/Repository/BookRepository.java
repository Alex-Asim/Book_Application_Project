package com.project.Book_Project.Repository;

import com.project.Book_Project.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
