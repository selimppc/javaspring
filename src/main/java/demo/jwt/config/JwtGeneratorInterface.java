package demo.jwt.config;

import demo.jwt.entity.User;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}
