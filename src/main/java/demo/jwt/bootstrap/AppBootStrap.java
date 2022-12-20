package demo.jwt.bootstrap;

import demo.jwt.entity.User;
import demo.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AppBootStrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AppBootStrap(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Optional<User> user1 = Optional.ofNullable(userRepository.findByUsernameAndPassword("user", "password"));
        if (user1.isEmpty()){
            User userX = new User(1, "user", "password", "ROLE_USER", true);
            userRepository.save(userX);
        }

        Optional<User> user2 = Optional.ofNullable(userRepository.findByUsernameAndPassword("user", "password"));
        if (user1.isEmpty()){
            User userY = new User(2, "admin", "admin", "ROLE_ADMIN", true);
            userRepository.save(userY);
        }


    }
}