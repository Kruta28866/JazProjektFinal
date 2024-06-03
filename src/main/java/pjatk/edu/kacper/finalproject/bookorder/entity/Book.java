package pjatk.edu.kacper.finalproject.bookorder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import pjatk.edu.kacper.finalproject.bookorder.entity.User;
//Książka powinna zawierać:
//Autora, Gatunek, Cenę, Ilość stron, licznik odwiedzin, oraz informację czy jest dostępna (ile sztuk).
//Autor powinien być osobną klasą, encją bazodanową.
//Książka, po jej wyszukaniu powinna inkrementować ilość odwiedzin.

@Entity // Mówimy jpa że jest to odwzorowanie bazodanowe jakies tabelki, dzięki adnotacjom stworzyła się baza danych
@Data  // gettery settery args construktory.
@Table(name = "books") // Wskazujemy na nazwę tabeli w serverze bazodanowym
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bedzie generowac mi id.
    private Long id;

    private String genere;
    private String title;
    private double price;
    private int pages;
    private int entries;
    private int quantity;

    @ManyToOne // To mowi java persistance api że tutaj mam połączenie i połączenie ze sobą tabel
    @JoinColumn(name = "author_id", nullable = false)//
    private Author author;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private Set<User> userBooks = new HashSet<>();

}
