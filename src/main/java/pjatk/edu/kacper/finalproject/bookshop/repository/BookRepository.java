package pjatk.edu.kacper.finalproject.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
