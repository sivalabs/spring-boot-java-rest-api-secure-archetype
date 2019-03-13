package com.sivalabs.myapp.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

public class SecurityUser extends User {

    public SecurityUser(com.sivalabs.myapp.entity.User user) {
        super(user.getUsername(),
              user.getPassword(),
              user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList()));
    }

}
