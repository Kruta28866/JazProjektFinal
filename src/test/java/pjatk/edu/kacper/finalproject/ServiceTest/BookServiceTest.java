package pjatk.edu.kacper.finalproject.ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pjatk.edu.kacper.finalproject.bookshop.entity.Author;
import pjatk.edu.kacper.finalproject.bookshop.services.BookService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest()
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getBookByAuthor_shouldReturnEmptyList() {
        //prepare
        //execute
        var books = bookService.getBookByAuthor(new Author());
        //assert
        assertEquals(new ArrayList<>(), books);


    }
}
