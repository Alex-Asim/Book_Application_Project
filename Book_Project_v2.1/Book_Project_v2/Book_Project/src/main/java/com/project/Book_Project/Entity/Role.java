// This file belongs to the package Entity (Role). The entity's classes are used to Java Persistence API (JPA) for the connection between Java's objects and Database.
package com.project.Book_Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
//Entity class representing the roles in the system.
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}