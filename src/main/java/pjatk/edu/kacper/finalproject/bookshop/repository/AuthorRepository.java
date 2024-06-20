package pjatk.edu.kacper.finalproject.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pjatk.edu.kacper.finalproject.bookshop.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    //o co chodzi z tym api genem, połaczeniem feign,
    // zapytac się czy oni maja dwie oddzielne bazy danych na moduły czy działają na tej samej
    // jak robią logowanie highlevel, jak robią to logowanie
    //TODO Zrobić testy jednostkowe dla repozytorium i dla servis
//
//    @Query("select a.id from Author a")
//    Author findAuthorById(Long id);
}
