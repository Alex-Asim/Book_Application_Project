// This file is reffered to a DTO (Data Transfer Object) object I have create which named "BookDto".
// We can use this kind of objects to transfer data among different levels of our application(diffirent files),
// For example between front-end and back-end.
// This file give us the structure of our data that will be transfered for the create, read and update of the books.
package com.project.Book_Project.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
// Lombok creates automatically getter, setter, equals, hashCode and toString for classes fields.
import lombok.Data;

@Data
public class BookDto {

    private long id;

    @NotEmpty
    @Size(min=4, message="Book title should have at least 4 characters!")
    private String title;

    @NotEmpty
    @Size(min=2, message = "Author name should have at least 2 characters!")
    private String author;
}
