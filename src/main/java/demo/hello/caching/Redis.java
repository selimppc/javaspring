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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uniqueidentifier default newid()", unique = true, updatable = false, nullable = false)
    private String id;

    private String title;
    private String description;

    public Redis(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
