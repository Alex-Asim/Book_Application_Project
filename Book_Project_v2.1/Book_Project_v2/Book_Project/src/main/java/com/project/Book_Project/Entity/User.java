// This file belongs to the package Entity (Users). The entity's classes are used to Java Persistence API (JPA) for the connection between Java's objects and Database.
package com.project.Book_Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//  Lombok labels - Next 4 lines
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
// JPA (Java Persistence API) labels
@Entity
@Table(name = "users")
//Entity class representing a user in the system. Class User defines the entity of the relations roles and users.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // With the @Column annotation I identify the columns I want to have in a table.
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    // Set of roles assigned to the user. The relation between roles is many to many with the entity Role.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // The @JoinTable annotation
    @JoinTable(name = "users_roles",
            // "referencedColumnName" is the foreign key (the primary key of User's entity)
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            // "referencedColumnName" is the foreign key ( the primary key of Role's entity)
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    // The following method returns the roles that have been assigned to each user.
    public Set<Role> getRoles() {
        return roles;
    }
}
