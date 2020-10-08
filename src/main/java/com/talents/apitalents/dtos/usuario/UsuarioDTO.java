package com.talents.apitalents.dtos.usuario;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talents.apitalents.entities.Usuario;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String token;
    private List<FuncaoDTO> funcoes;

    public UsuarioDTO(Usuario usuario) {
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.funcoes = usuario.getFuncoes().stream().map(funcao -> new FuncaoDTO(funcao)).collect(Collectors.toList());
    }

    public UsuarioDTO(Usuario usuario, String token) {
        this(usuario);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FuncaoDTO> getFuncoes() {
        return funcoes;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
