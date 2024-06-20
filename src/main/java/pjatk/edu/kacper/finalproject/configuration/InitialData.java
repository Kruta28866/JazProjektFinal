package pjatk.edu.kacper.finalproject.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pjatk.edu.kacper.finalproject.bookshop.entity.Author;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;
import pjatk.edu.kacper.finalproject.bookshop.services.AuthorService;
import pjatk.edu.kacper.finalproject.bookshop.services.BookService;

@Component
public class InitialData {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public InitialData(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    private synchronized void init() {
        if (bookService.getAllBooks().isEmpty()) {
            Author kacper = Author.builder().name("Kacper").build();
            Author pawel = Author.builder().name("pawel").build();

            authorService.saveAuthor(kacper);
            authorService.saveAuthor(pawel);

            Book book = Book.builder().pages(2137).price(30).genere("Horror").title("Ania z zielonego wzgórza").quantity(4).author(kacper).build();
            Book book1 = Book.builder().pages(420).price(30).genere("Komedia").title("Ania z zielonego").quantity(2).author(kacper).build();
            Book book2 = Book.builder().pages(269).price(30).genere("Thriller").title("z zielonego wzgórza").quantity(5).author(kacper).build();
            Book book3 = Book.builder().pages(299).price(30).genere("Sci-Fi").title("Ania z wzgórza").quantity(3).author(pawel).build();
            Book book4 = Book.builder().pages(211).price(30).genere("Obyczajowy").title("Ania").quantity(8).author(pawel).build();
            Book book5 = Book.builder().pages(223).price(30).genere("Dramat").title("wzgórza").quantity(2).author(pawel).build();

            bookService.saveBook(book, kacper.getId());
            bookService.saveBook(book1, kacper.getId());
            bookService.saveBook(book2, kacper.getId());
            bookService.saveBook(book3, pawel.getId());
            bookService.saveBook(book4, pawel.getId());
            bookService.saveBook(book5, pawel.getId());
        }
    }

}
