package com.avatar.user.crud.service;

import com.avatar.user.crud.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private User user;

    // dummy or static data ::
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("1", "Omar ", " Farooq"),
            new User("2", "Omar ", " Farooq"),
            new User("3", "Omar ", " Farooq"),
            new User("4", "Omar ", " Farooq"),
            new User("5", "Omar ", " Farooq"),
            new User("6", "Omar ", " Farooq")
    ));


    public List<User> allUsers(){
        return users;
    }

    public User getUser(String id){
        User user = users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
        return user;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public void updateUser(String id, User user){
        for (int i =0; i < users.size(); i++){
            User u = users.get(i);

            if (u.getId().equals(id)){
                users.set(i, user);
            }
        }
    }

    public void deleteUser(String id){
        users.removeIf(u -> u.getId().equals(id));
    }


}
