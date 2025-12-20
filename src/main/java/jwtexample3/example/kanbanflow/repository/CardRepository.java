package jwtexample3.example.kanbanflow.repository;

import jwtexample3.example.kanbanflow.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    java.util.List<Card> findByColumnId(String columnId);
}
