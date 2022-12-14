package demo.hello.caching;

import demo.hello.caching.RedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DataFixtureCommand implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RedisRepository redisRepository;

    @Autowired
    public DataFixtureCommand(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @Override
    public void run(String... strings) {

        //Populating embedded database here
        // LOG.info("Saving users. Current user count is {}.", redisRepository.count());

        String title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        String description = title;

        //save
//        for (int i= 0; i < 21; i++) {
//            redisRepository.save(new Redis(title, description));
//        }

        // LOG.info("Data Saved. total : " + redisRepository.count());
    }
}