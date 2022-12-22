package demo.jwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role implements Serializable {

//    final String ROLE_USER = "ROLE_USER";
//    final String ROLE_ADMIN = "ROLE_ADMIN";
//    final String ROLE_OPERATOR = "ROLE_OPERATOR";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private int id;
    private String title;

    public Role(String title) {
        this.title = title;
    }

}
