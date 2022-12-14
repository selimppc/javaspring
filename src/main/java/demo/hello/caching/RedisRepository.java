package demo.hello.caching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RedisRepository extends JpaRepository<Redis, String> {
}
