package com.example.restfulapi.controller;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired // Spring Boot sẽ quét tron Context và trả về 1 userService
    private UserService userService;

//    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    @GetMapping("") //cách 2
    public ResponseEntity<?> getListUsers(){
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}") //ta cần tham số hứng giá trị id trong đường dẫn này
    public ResponseEntity<?> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUerById(id));
    }

    //API giúp tìm kiếm
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
        return ResponseEntity.ok(userService.searchUser(name));
    }

    @PostMapping("")
    public ResponseEntity<?> createUsers(){

        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsers(){

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsers(){

        return null;
    }
}
