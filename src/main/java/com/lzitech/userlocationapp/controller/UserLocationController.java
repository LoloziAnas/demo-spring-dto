package com.lzitech.userlocationapp.controller;

import com.lzitech.userlocationapp.dto.UserLocationDTO;
import com.lzitech.userlocationapp.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLocationController {
    private final UserLocationService userLocationService;

    @Autowired
    public UserLocationController(UserLocationService userLocationService){
        this.userLocationService = userLocationService;
    }

    @GetMapping("/map")
    @ResponseBody
    public List<UserLocationDTO> getAllUsersLocation(){
        return userLocationService.getAllUsersLocation();
    }

}
