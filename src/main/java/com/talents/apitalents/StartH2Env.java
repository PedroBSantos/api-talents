package com.talents.apitalents;

import java.util.Arrays;

import com.talents.apitalents.entities.Role;
import com.talents.apitalents.entities.User;
import com.talents.apitalents.repositories.RoleRepository;
import com.talents.apitalents.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StartH2Env {

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void start() {
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            Role role1 = new Role("ROLE_USER");
            Role role2 = new Role("ROLE_ADMIN");
            Role role3 = new Role("ROLE_INTERVIEWER");
            Role role4 = new Role("ROLE_INTERVIEWEE");
            role1 = this.roleRepository.save(role1);
            role2 = this.roleRepository.save(role2);
            role3 = this.roleRepository.save(role3);
            role4 = this.roleRepository.save(role4);
            User user1 = new User("epigen@email.com", "$2a$10$tNMWVoWKxqsu7gG.yOzxAemX7Bj0eFm0PTWhmd1VTy9gfxQVN02VG");
            User user2 = new User("talents@email.com", "$2a$10$QBj5t19wMvDd8jJaYaYgwudZNyJ8V.ZYD57J/sR/EWXzhmBQzhjfG");
            user1.getRoles().add(role1);
            user1.getRoles().add(role2);
            user2.getRoles().add(role1);
            user2.getRoles().add(role2);
            usuarioRepository.save(user1);
            usuarioRepository.save(user2);
        }
    }
}
