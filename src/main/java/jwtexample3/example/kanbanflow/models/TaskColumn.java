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

    Double position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    Board board;

    @OneToMany(mappedBy = "column",cascade = CascadeType.ALL,orphanRemoval = true)
    java.util.List<Card> cards =new java.util.ArrayList<>();

}
