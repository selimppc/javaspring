package demo.hello.caching;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedisService {

    @Autowired
    RedisRepository redisRepository;

    // return all data
    public List<Redis> getAllRedisData() {
       return redisRepository.findAll();
    }

    public Optional<Redis> getDataById(String id){
        return redisRepository.findById(id);
    }
}
