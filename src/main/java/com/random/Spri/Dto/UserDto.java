package com.random.Spri.Dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String email;
    private String phone;


    public UserDto(){
    }

    public UserDto(Long id, String userName, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
