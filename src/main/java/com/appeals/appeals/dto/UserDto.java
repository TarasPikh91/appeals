package com.appeals.appeals.dto;

import com.appeals.appeals.domain.Appeal;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;
import lombok.Getter;
import lombok.Setter;

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

@Getter
@Setter
public class UserDto {

    private long id;
    private String username;
    private String fullUsername;
    private String password;
    private String email;
    private String phone;
    private boolean locked;
    private boolean isEnabled;
    private UserRole userRole;
    private List<Appeal> appeals = new ArrayList<Appeal>();

    public UserDto(long id, String username, String fullUsername, String password, String email, String phone, boolean locked, boolean isEnabled, UserRole userRole, List<Appeal> appeals) {
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
}
