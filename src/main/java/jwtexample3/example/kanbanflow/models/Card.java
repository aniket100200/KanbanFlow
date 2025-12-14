package jwtexample3.example.kanbanflow.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_card")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String title;
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "column_id")
    TaskColumn column;

    Double position;

}
