package com.api.jwtsecurity.data;

import com.api.jwtsecurity.model.Role;
import com.api.jwtsecurity.model.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.util.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserDetailsData implements UserDetails {

    private final Optional<User> user;
    private List<Role> authorities;

    public UserDetailsData(Optional<User> user) {
        this.user = user;
        //List<SimpleGrantedAuthority> authorities = user.orElseGet(user.get().getCargos());

    }


    @Override
    public List<Role> getAuthorities() {  //autoridades dos usuarios
        //return user.get().getCargos();
        System.out.println("response:" + user);
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.orElse(new User()).getPassword();
    }

    @Override
    public String getUsername() {
        return user.orElse(new User()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
