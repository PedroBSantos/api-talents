package com.talents.apitalents.services;

import com.talents.apitalents.dtos.user.UserDTO;
import com.talents.apitalents.dtos.user.UserInsertDTO;
import com.talents.apitalents.entities.CustomRole;
import com.talents.apitalents.entities.CustomUser;
import com.talents.apitalents.repositories.RoleRepository;
import com.talents.apitalents.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = false)
    public UserDTO create(UserInsertDTO userInsertDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoded = encoder.encode(userInsertDTO.getPassword());
        CustomUser user = new CustomUser(userInsertDTO.getUsername(), passwordEncoded);
        CustomRole role = this.roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        if (userInsertDTO.isInterviewer()) {
            role = this.roleRepository.findByName("ROLE_INTERVIEWER");
            user.getRoles().add(role);
        } else {
            role = this.roleRepository.findByName("ROLE_INTERVIEWEE");
            user.getRoles().add(role);
        }
        user = this.userRepository.save(user);
        UserDTO userDTO = new UserDTO(user);
        userDTO.setPassword(null);
        return userDTO;
    }
}
