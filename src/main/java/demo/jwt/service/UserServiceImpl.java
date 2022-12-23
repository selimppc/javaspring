package demo.jwt.service;


import demo.jwt.entity.Role;
import demo.jwt.entity.User;
import demo.jwt.exception.UserNotFoundException;
import demo.jwt.repository.RoleRepository;
import demo.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }



    private String encode(String password) {
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        return encoder.encode(password);
    }


    @Override
    public String saveUser(User user) {

        User newUser = userRepository.getUserByUsername(user.getUsername());
        if (newUser == null) {
            newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(this.encode(user.getPassword()));
            newUser.setEnabled(true);
        }

        // SAVE new USER
        return this.createAndAssignRole(user, newUser);

        //OLD
        //userRepository.save(user);
    }


    private String createAndAssignRole(User user, User newUser)
    {
        // ROLES
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {

            // check Role OR Create new one
            Role checkRole = roleRepository.findByTitle(role.getTitle());
            if (checkRole == null) {
                checkRole = roleRepository.save(role);
            }

            // Check Role is already assigned or assign
            if (!newUser.getRoles().contains(checkRole)) {
                newUser.getRoles().add(checkRole);
            }
        }

        try{
            userRepository.save(newUser);
        }catch (Exception e){
            return e.getMessage();
        }
        return "User and Role have been assigned -> Successfully!";
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return user;
    }

    @Override
    public List<User> allUsers(){
        return userRepository.findAll();
    }


}
