package com.demo.H5.W3.Book.management.Service;

import com.demo.H5.W3.Book.management.Exceptions.InvalidIdException;
import com.demo.H5.W3.Book.management.Model.Book;
import com.demo.H5.W3.Book.management.Model.User;
import com.demo.H5.W3.Book.management.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    //to check user is invalid by user id
    public void checkUserIsInvalid(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));

    }
}
