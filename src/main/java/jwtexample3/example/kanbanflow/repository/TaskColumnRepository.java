package jwtexample3.example.kanbanflow.repository;

import jwtexample3.example.kanbanflow.models.TaskColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskColumnRepository extends JpaRepository<TaskColumn, String> {
}
