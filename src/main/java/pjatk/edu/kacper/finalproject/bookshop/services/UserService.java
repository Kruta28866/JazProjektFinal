package pjatk.edu.kacper.finalproject.bookshop.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;
import pjatk.edu.kacper.finalproject.bookshop.entity.User;
import pjatk.edu.kacper.finalproject.bookshop.repository.BookRepository;
import pjatk.edu.kacper.finalproject.bookshop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    //zrobienie użytkownika
    //Kupienie książki

    final private UserRepository userRepository;
    final private BookRepository bookRepository;

    @Autowired
    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }


    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public List<Book> buyBook(User user, Long bookId) {

        var book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            user.getBooks().add(book.get());
            userRepository.save(user);
        }

        return user.getBooks().stream().toList();
    }


}
