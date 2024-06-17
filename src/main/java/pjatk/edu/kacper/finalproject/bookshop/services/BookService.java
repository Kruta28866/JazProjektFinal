package pjatk.edu.kacper.finalproject.bookshop.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.edu.kacper.finalproject.bookshop.entity.Author;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;
import pjatk.edu.kacper.finalproject.bookshop.repository.AuthorRepository;
import pjatk.edu.kacper.finalproject.bookshop.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    final private BookRepository bookRepository;
    final private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }



    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    //Optional ->
    public Optional<Book> getBookByName(String title) {
        var books = bookRepository.findAll();

        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    public List<Book> getBookByAuthor(Author author) {
        if (author.getId()!= null) {
            var foundAuthor = authorRepository.findById(author.getId());
            if (foundAuthor.isPresent()) {
                var books = bookRepository.findAll();
                return books.stream()
                        .filter(book -> book.getAuthor().equals(author))
                        .toList();
            }
        }
            return new ArrayList<>();

        }


    @Transactional //Zabezpieczenie do bazy danych po nieudanej próbie stworzenia zrobi się rollback.
    public void saveBook(Book book,Long authorId) {
        var foundAuthor = authorRepository.findById(authorId);
        if (foundAuthor.isPresent()) {
            book.setAuthor(foundAuthor.get());
            bookRepository.save(book);
        }
    }

    public void deleteBook(Long bookId){
        var foundBook = bookRepository.findById(bookId);
        foundBook.ifPresent(bookRepository::delete);
    }

}
