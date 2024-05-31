package pjatk.edu.kacper.finalproject.bookorder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bedzie generowac mi id.
    private Long id;
    private String name;

    // Mapuje przez authora i kaskada mówi że jeżeli usunę auhtora i jeżeli zostanie usunięty author
    // zostaną usunięte książki powiązane z tym authorem.
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}
