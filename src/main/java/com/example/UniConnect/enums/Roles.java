package com.example.UniConnect.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER {
        @Override
        public String getAuthority(){
            return "ROLE_USER";
        }
    }, ADMIN {
        @Override
        public String getAuthority(){
            return "ROLE_ADMIN";
        }
    };

    @Override
    public String getAuthority() {
        return null;
    }
}
