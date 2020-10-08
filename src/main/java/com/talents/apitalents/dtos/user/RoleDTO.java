package com.talents.apitalents.dtos.user;

import java.io.Serializable;

import com.talents.apitalents.entities.Role;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public RoleDTO(Role role) {
        this.name = role.getAuthority();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
