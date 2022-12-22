package demo.hello.caching;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedisService {

    @Autowired
    RedisRepository redisRepository;

    // return all data
    public Page<Redis> getAllRedisData(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
       return redisRepository.findAll(paging);
    }

    public Optional<Redis> getDataById(String id){
        return redisRepository.findById(id);
    }


    public Page<Redis> getRedisByTitle(String title, int page, int size){
        Pageable paging = PageRequest.of(page, size);
        return redisRepository.findByTitle(title, paging);
    }
}
