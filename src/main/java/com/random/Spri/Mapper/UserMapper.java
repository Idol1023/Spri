package com.random.Spri.Mapper;

import com.random.Spri.Dto.UserDto;
import com.random.Spri.Model.User;


public class UserMapper {
    public static UserDto toDTO(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUserName(dto.getUserName());
        user.setPassword(user.getPassword());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }
}
