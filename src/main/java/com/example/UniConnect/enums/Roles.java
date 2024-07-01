package com.example.UniConnect.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER {
        @Override
        public String getAuthority(){
            return "USER";
        }
    }, ADMIN {
        @Override
        public String getAuthority(){
            return "ADMIN";
        }
    };

    @Override
    public String getAuthority() {
        return null;
    }
}
