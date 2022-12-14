package demo.hello.caching;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class CacheResourceController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RedisService redisService;

    @Autowired
    public CacheResourceController(RedisService redisService) {
        this.redisService = redisService;
    }

    @Cacheable(value="resources")
    @GetMapping("/resources")
    @ResponseBody
    public List<Redis> getAllData() {
        return redisService.getAllRedisData();
    }

    //@Cacheable(value = "resources", key = "#id", unless = "#result.resources < 120")
    @Cacheable(value="resources", key="#id")
    @GetMapping("/resources/{id}")
    @ResponseBody
    public Optional<Redis> getData(@PathVariable String id){
        return redisService.getDataById(id);
    }









//    @Caching(evict = {
//            @CacheEvict("resources"),
//            @CacheEvict(value="employee", key="#employee.id")
//    })
//    public Redis getEmployee(Redis redis) {
//        return redis;
//    }
//
//
//    @CachePut(value = "resources", key = "#redis.id")
//    @PutMapping("/{id}")
//    public Redis updatePersonByID(@RequestBody Redis redis) {
//        //
//    }


//    @CacheEvict(value="resources", allEntries=true)
//    @CacheEvict(value="resources", key="#id")
//    @DeleteMapping("/{id}")
//    public void deleteUserByID(@PathVariable String id) {
//    }


}
