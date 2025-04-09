package com.gouri.general.model.dto;

import com.azure.core.annotation.Get;
import com.gouri.general.model.Users;
import lombok.Data;

@Data
public class UserRequest{
    private String name;
    private String email;
    private String nationality;
    private String c_no;


    public Users toUserInfo(){
        return Users.builder()
                .name(name)
                .emailId(email)
                .Nationality(nationality)
                .phoneNumber(c_no).build();
    }
}
