package jwtexample3.example.kanbanflow.repository;

import jwtexample3.example.kanbanflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByPhone(String phone);
    User findByEmail(String email);
    void deleteByPhone(String phone);
    void deleteByEmail(String email);
}
