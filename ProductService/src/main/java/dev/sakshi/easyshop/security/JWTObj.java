package dev.sakshi.easyshop.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
public class JWTObj {
    private String email;
    private Long userId;
    private Date createdAt;
    private Date expireAt;
    private List<Role> roles;

}
