package jwtexample3.example.kanbanflow.repository;

import jwtexample3.example.kanbanflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

}
