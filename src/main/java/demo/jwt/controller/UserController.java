package demo.jwt.controller;

import demo.jwt.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public String users() {
        return "Hello, " ;
    }

}
