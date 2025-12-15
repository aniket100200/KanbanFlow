package jwtexample3.example.kanbanflow.repository;

import jwtexample3.example.kanbanflow.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
}
