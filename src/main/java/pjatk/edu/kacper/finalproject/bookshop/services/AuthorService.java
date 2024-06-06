package pjatk.edu.kacper.finalproject.bookshop.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.edu.kacper.finalproject.bookshop.entity.Author;
import pjatk.edu.kacper.finalproject.bookshop.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public void saveAuthor(Author author){
        authorRepository.save(author);
    }
}
