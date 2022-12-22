package demo.hello.caching;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface RedisRepository extends JpaRepository<Redis, String> {

    //Page<Redis> findAll(Pageable pageable);

    Page<Redis> findByTitle(String title, Pageable pageable);
}
