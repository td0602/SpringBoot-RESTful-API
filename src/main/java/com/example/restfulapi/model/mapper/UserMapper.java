
/*
//Convert data từ User sang User Mapper
 */
package com.example.restfulapi.model.mapper;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.model.dto.UserDto;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setAvatar(user.getAvatar());
        tmp.setPhone(user.getPhone());
        tmp.setEmail(user.getEmail());

        return tmp;
    }
}
