package jwtexample3.example.kanbanflow.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_taks_column")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String title;
    @Column(name = "board_id")
    String boardId;

    Double position;
}
