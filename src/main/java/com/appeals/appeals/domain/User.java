package com.appeals.appeals.domain;

import com.appeals.appeals.dto.UserDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "users_data")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @Column(name = "full_username")
    private String fullUsername;
    private String password;
    private String email;
    private String phone;
    private boolean locked;
    @Column(name = "enabled")
    private boolean isEnabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appeal> appeals = new ArrayList<Appeal>();

    public User() {}

    public User(String username, String fullUsername, String password, String email, String phone, UserRole userRole) {
        this.username = username;
        this.fullUsername = fullUsername;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userRole = userRole;
    }

    public User(final UserDto userDto) {
        this.username = userDto.getUsername();
        this.fullUsername = userDto.getFullUsername();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.phone = userDto.getPhone();
        this.userRole = userDto.getUserRole();
    }

    public UserDto convertToDto() {
        return new UserDto(this.id, this.username, this.fullUsername, this.password, this.email, this.phone, this.locked, this.isEnabled, this.userRole, this.appeals);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.getUserRole().name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }
}
