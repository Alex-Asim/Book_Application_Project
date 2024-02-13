// This file belongs to the package Entity (Book). The entity's classes are used to Java Persistence API (JPA) for the connection between Java's objects and Database.
package com.project.Book_Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// The following class represents an entity.
@Entity
// Initialize the name of the table in Database.
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Set the primary key for our Database.
    private long id;

    // Set the table's columns
    @Column(name="title",nullable=false)
    private String title;

    @Column(name="author",nullable=false)
    private String author;


}
