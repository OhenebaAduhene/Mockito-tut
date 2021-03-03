package com.example.springsecuritytut.model;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springsecuritytut.model.ApplicationUserPermission.*;


@AllArgsConstructor
@Getter
public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_WRITE,COURSE_READ)),
    STUDENT(Sets.newHashSet()),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ));


    private Set<ApplicationUserPermission> permissions;


    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        final Set<SimpleGrantedAuthority> _permission = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        _permission.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return _permission;
    }


}
