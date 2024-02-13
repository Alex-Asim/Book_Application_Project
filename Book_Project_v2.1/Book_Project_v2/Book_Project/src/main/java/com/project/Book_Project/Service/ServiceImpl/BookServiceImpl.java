package com.project.Book_Project.Service.ServiceImpl;

import com.project.Book_Project.Dto.BookDto;
import com.project.Book_Project.Entity.Book;
import com.project.Book_Project.Exception.ResourceNotFoundException;
import com.project.Book_Project.Repository.BookRepository;
import com.project.Book_Project.Service.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {

        // Create Dto to Entity
        Book book = mapTOEntity(bookDto);
        Book newBook = bookRepository.save(book);

        // Create Entity to Dto
        BookDto bookResponse = mapTODTO(newBook);
        return bookResponse;
    }

    @Override
    public BookDto getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Book","id",id));
        return mapTODTO(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, long id) {

        // Get book from the database by its id
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book","id",id));

        // Update book properties with values from the DTO
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());

        // Save the updated book to the database
        Book updateBook = bookRepository.save(book);
        return mapTODTO(updateBook);
    }

    @Override
    public void deleteBookById(long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book","id",id));
        bookRepository.delete(book);
    }

    private BookDto mapTODTO(Book book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    private Book mapTOEntity(BookDto bookDto){
        Book book = modelMapper.map(bookDto,Book.class);
        return book;
    }
}
