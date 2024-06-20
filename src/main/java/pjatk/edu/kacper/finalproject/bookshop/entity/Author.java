package pjatk.edu.kacper.finalproject.bookshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "books")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bedzie generowac mi id.
    private Long id;
    private String name;

    // Mapuje przez authora i kaskada mówi że jeżeli usunę auhtora i jeżeli zostanie usunięty author
    // zostaną usunięte książki powiązane z tym authorem(Cascade).
    @JsonManagedReference
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;
}
