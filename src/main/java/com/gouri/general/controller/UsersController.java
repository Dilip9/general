package com.gouri.general.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users/")
public class UsersController {

    @Autowired
    private UserService userService;

    public ResponseEntity<UserInfo> createUser(@RequestBody @Valid CreateUserRequest request){
        return new ResponseEntity<>(userService.createNewUser(request), HttpStatus.CREATED);
    }


}
