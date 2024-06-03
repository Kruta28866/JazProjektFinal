package pjatk.edu.kacper.finalproject.bookorder.entity;

import jakarta.persistence.*;
import lombok.Data;
import pjatk.edu.kacper.finalproject.bookorder.types.Roles;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
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
