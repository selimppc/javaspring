package demo.jwt.service;


import demo.jwt.entity.User;
import demo.jwt.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public void saveUser(User user);

    public User getUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, UserNotFoundException;

    public List<User> allUsers();
}