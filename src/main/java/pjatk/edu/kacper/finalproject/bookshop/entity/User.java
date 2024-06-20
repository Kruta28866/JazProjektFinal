package pjatk.edu.kacper.finalproject.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pjatk.edu.kacper.finalproject.bookshop.types.Roles;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bedzie generowac mi id.
    private int id;
    private String name;
    private String password;
    private Roles roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userBooks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();
}
