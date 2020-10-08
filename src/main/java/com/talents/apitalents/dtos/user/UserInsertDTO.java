package com.talents.apitalents.dtos.user;

import java.io.Serializable;

public class UserInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean interviewer;

    public UserInsertDTO() {
    }

    public UserInsertDTO(String username, String password, boolean interviewer) {
        this.username = username;
        this.password = password;
        this.interviewer = interviewer;
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

    public boolean isInterviewer() {
        return interviewer;
    }

    public void setInterviewer(boolean interviewer) {
        this.interviewer = interviewer;
    }
}
