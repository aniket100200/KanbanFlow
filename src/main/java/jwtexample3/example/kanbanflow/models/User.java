package jwtexample3.example.kanbanflow.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String firstName;
    String lastName;
    @Column(nullable = false)
    String email;

    @Column(nullable = false, unique = true)
    String phone;
    String password;


    String address;

    String city;

    String state;
}
