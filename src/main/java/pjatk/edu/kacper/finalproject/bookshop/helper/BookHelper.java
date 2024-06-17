package pjatk.edu.kacper.finalproject.bookshop.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;
import pjatk.edu.kacper.finalproject.bookshop.repository.BookRepository;

@Component

public class BookHelper {

    private final BookRepository bookRepository;

    @Autowired
    public BookHelper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void incrementEntry(Book book) {
        book.setEntries(book.getEntries() + 1);

        bookRepository.save(book);
    }
}
