package com.appeals.appeals.dto;

import com.appeals.appeals.domain.Appeal;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private int id;
    private String username;
    private String fullUsername;
    private String password;
    private String email;
    private String phone;
    private boolean locked;
    private boolean isEnabled;
    private UserRole userRole;
    private List<Appeal> appeals = new ArrayList<Appeal>();

    public UserDto(int id, String username, String fullUsername, String password, String email, String phone, boolean locked, boolean isEnabled, UserRole userRole, List<Appeal> appeals) {
        this.id = id;
        this.username = username;
        this.fullUsername = fullUsername;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.locked = locked;
        this.isEnabled = isEnabled;
        this.userRole = userRole;
        this.appeals = appeals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Appeal> getAppeals() {
        return appeals;
    }

    public void setAppeals(List<Appeal> appeals) {
        this.appeals = appeals;
    }
}
