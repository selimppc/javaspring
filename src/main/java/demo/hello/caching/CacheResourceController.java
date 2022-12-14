package demo.hello.caching;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Page<Redis> getAllData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return redisService.getAllRedisData(page, size);
    }

    //@Cacheable(value = "resources", key = "#id", unless = "#result.resources < 120")
    @Cacheable(value="resources", key="#id")
    @GetMapping("/resources/{id}")
    @ResponseBody
    public Optional<Redis> getData(@PathVariable String id){
        return redisService.getDataById(id);
    }



    @GetMapping("/resources/title/{title}")
    @ResponseBody
    public Page<Redis> getByTitle(
            @PathVariable String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        return redisService.getRedisByTitle(title, page, size);
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
