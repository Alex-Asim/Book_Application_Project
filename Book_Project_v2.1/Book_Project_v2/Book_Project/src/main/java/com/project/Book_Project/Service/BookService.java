package com.project.Book_Project.Service;

import com.project.Book_Project.Dto.BookDto;

public interface BookService {

    BookDto createBook(BookDto bookDto);
    BookDto getBookById(long id);
    BookDto updateBook(BookDto bookDto, long id);
    void deleteBookById(long id);

//    BookDto updateBook(long id);
}
