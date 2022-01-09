package com.h2sm.mainservice.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

;import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Position {
    Director(Set.of(Permission.DIRECTOR_READ, Permission.DIRECTOR_WRITE)),
    HeadOfDepartment(Set.of(Permission.HEAD_READ, Permission.HEAD_WRITE)),
    DepartmentWorker(Set.of(Permission.DEPWORKER_READ, Permission.DEPWORKER_WRITE));

    private final Set<Permission> permissions;


    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}
