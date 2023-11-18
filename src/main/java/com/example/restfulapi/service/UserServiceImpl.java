package com.example.restfulapi.service;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.exception.NotFoundException;
import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    // mảng User động thay cho database
    private static ArrayList<User> users= new ArrayList<User>();

    //Thêm sẵn dữ liệu ban đầu
    static {
        users.add(new User(1, "Nguyễn Văn A", "a@gmail.com", "1", "a_avatar.img", "a"));
        users.add(new User(2, "Nguyễn Văn B", "b@gmail.com", "2", "a_avatar.img", "b"));
        users.add(new User(3, "Nguyễn Văn C", "c@gmail.com", "3", "a_avatar.img", "c"));
        users.add(new User(4, "Nguyễn Văn D", "d@gmail.com", "4", "a_avatar.img", "d"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> results = new ArrayList<>();
        for(User u: users) {
            results.add(UserMapper.toUserDto(u));
        }
        return results;
    }

    @Override
    public UserDto getUerById(int id) {
        for(User user: users) {
            if(user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> results = new ArrayList<>();
        for(User user: users) {
            if(user.getName().contains(keyword)) {
                results.add(UserMapper.toUserDto(user));
            }
        }
        return null;
    }
}
