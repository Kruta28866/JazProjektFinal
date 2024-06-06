package pjatk.edu.kacper.finalproject.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjatk.edu.kacper.finalproject.bookshop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
