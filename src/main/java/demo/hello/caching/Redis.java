package demo.hello.caching;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "redis_data")
@NoArgsConstructor
public class Redis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // FOR MSSQL @Column(name = "id", columnDefinition = "uniqueidentifier default newid()", unique = true, updatable = false, nullable = false)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private int id;

    private String title;
    private String description;

    public Redis(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
