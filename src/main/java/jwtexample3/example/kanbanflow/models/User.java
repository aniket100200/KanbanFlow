package jwtexample3.example.kanbanflow.models;

import jakarta.persistence.*;
import jwtexample3.example.kanbanflow.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

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


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "t_user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    Set<Role> roles;


    String address;

    String city;

    String state;
}
