package dev.sakshi.easyshop.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonDeserialize(as = Role.class)
public class Role {
    private Long id;
    private String role;
}
