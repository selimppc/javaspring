package demo.jwt.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;



@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // for MSSQL @Column(name = "id", columnDefinition = "uniqueidentifier default newid()", unique = true, updatable = false, nullable = false)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private int id;

    private String username;
    private String password;

    @Nullable
    private String roles;

    @Nullable
    private boolean enabled;

    public User(int id, String username, String password, String roles, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }

}
