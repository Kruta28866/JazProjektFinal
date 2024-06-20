package pjatk.edu.kacper.finalproject.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query("select b from Book b")
    List<Book> findAllBooks();
}
