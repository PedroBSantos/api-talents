package com.talents.apitalents;

import java.util.Arrays;

import com.talents.apitalents.entities.Funcao;
import com.talents.apitalents.entities.Usuario;
import com.talents.apitalents.repositories.FuncaoRepository;
import com.talents.apitalents.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StartH2Env {

    @Autowired
    private Environment env;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FuncaoRepository funcaoRepository;

    public void start() {
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            Funcao funcao1 = new Funcao("ROLE_USER");
            Funcao funcao2 = new Funcao("ROLE_ADMIN");
            funcao1 = this.funcaoRepository.save(funcao1);
            funcao2 = this.funcaoRepository.save(funcao2);
            Usuario usuario1 = new Usuario("epigen@email.com",
                    "$2a$10$tNMWVoWKxqsu7gG.yOzxAemX7Bj0eFm0PTWhmd1VTy9gfxQVN02VG");
            Usuario usuario2 = new Usuario("talents@email.com",
                    "$2a$10$QBj5t19wMvDd8jJaYaYgwudZNyJ8V.ZYD57J/sR/EWXzhmBQzhjfG");
            usuario1.getFuncoes().add(funcao1);
            usuario1.getFuncoes().add(funcao2);
            usuario2.getFuncoes().add(funcao1);
            usuario2.getFuncoes().add(funcao2);
            usuarioRepository.save(usuario1);
            usuarioRepository.save(usuario2);
        }
    }
}
