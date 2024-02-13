// This file is using Spring Framework for the creation of a RESTful API for book management. It has also a level of
// authorization (@PreAuthorize) annotation.

// Package name specification
package com.project.Book_Project.Controller;

// Necessary classes imports which has to do with validation, HTTP response, security annotations and libraries.
import com.project.Book_Project.Dto.BookDto;
import com.project.Book_Project.Service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

// Indicates that this class is a RESTFull Controller.
@RestController
// Necessary annotation if we want to use a constructor which can be used with the "@Autowired" annotation.
@AllArgsConstructor
// Sets the base URI for all mapping to be done on this controller.
@RequestMapping("api/projectBooks")
public class BookController {

    private BookService bookService;

    // It requires that the user must have "ADMIN" role to call this method.
    @PreAuthorize("hasAnyRole('ADMIN')")
    // The following annotation give us the ability to make HTTP POST requests.
    @PostMapping()
    // The following method takes an object "BookDto" from body request and it returns on "Response Entity" which includes the
    // result of the book creation with the suitable HTTP status (HttpStatus.CREATED).
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    // The following method takes an object "BookDto" from body request and it returns the specific book details with specifing ID.
    public ResponseEntity<BookDto> getBookById(@PathVariable (name="id") long id) {
        return new ResponseEntity<BookDto>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    // The following method takes an object "BookDto" from body request and it returns the result of the book update.
    public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto bookDto, @PathVariable(name="id") long id){
        return new ResponseEntity<>(bookService.updateBook(bookDto, id),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    // The following method takes an object "BookDto" from body request and it deletes the specific book with the id we refer to.
    public ResponseEntity<String> deleteBook(@PathVariable(name = "id") long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>("The book has been successfully deleted.",HttpStatus.OK);
    }
}
