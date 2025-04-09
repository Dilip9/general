package com.gouri.general.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Builder
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/admin/")
public class AdminController {


    @GetMapping("/getAllAdmin")
    public String getAdmin(){
        return "Admin";
    }

    @GetMapping("/getAdminById/{id}")
    public String getAdminById(@RequestParam Long adminId){
        return "Admin details based out ID";
    }
}
