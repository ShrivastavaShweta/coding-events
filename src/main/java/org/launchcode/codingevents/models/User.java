package org.launchcode.codingevents.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity{

    @NotNull
    private String userName;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, String password) {
        this.userName = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUserName() {
        return userName;
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }
}
