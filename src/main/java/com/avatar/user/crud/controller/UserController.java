package com.avatar.user.crud.controller;

import com.avatar.user.crud.entity.User;
import com.avatar.user.crud.service.UserService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    // R: L : get method with list of users
    @ResponseBody
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.allUsers();
    }

    // R: get single user by ID
    @ResponseBody
    @GetMapping("/users/{id}")
    @Nullable
    public ResponseEntity<?> getUser(@PathVariable String id) {
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        }catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    // add a user
    @ResponseBody
    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User u = userService.addUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    // update a user's metadata
    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user,@PathVariable String id){
        userService.updateUser(id, user);
    }

    // delete a user
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }


}
