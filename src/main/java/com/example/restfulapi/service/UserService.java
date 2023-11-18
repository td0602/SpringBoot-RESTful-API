package com.example.restfulapi.service;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();
    public UserDto getUerById(int id);
    public List<UserDto> searchUser(String keyword);
}
