package com.demo.H5.W3.Book.management.Controller;

import com.demo.H5.W3.Book.management.DTO.Api;
import com.demo.H5.W3.Book.management.Model.User;

import com.demo.H5.W3.Book.management.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    //Get all users
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        logger.info("get user");
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


    //Add new user
    @PutMapping("/add")
    public ResponseEntity<Api> addUser(@RequestBody User user){
        logger.info("add customer");
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("User added !",201));
    }

    //to check user is invalid by user id
    @GetMapping("/user/{id}")
    public ResponseEntity<Api> checkBookIsInvalid(@PathVariable Integer id){
        logger.info("check by user id");
        userService.checkUserIsInvalid(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid user id",200));
    }


}
