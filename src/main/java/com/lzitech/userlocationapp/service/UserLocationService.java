package com.lzitech.userlocationapp.service;

import com.lzitech.userlocationapp.dto.UserLocationDTO;
import com.lzitech.userlocationapp.model.User;
import com.lzitech.userlocationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserLocationService {

    private final UserRepository userRepository;

    @Autowired
    public UserLocationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserLocationDTO> getAllUsersLocation(){
        return  userRepository.findAll().stream().map(this::convertToUserLocationDTO).collect(Collectors.toList());
    }

    private UserLocationDTO convertToUserLocationDTO(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setUsername(user.getUsername());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        return userLocationDTO;
    }
}
