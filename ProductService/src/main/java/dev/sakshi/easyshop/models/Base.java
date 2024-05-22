package dev.sakshi.easyshop.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.lang.reflect.Type;
import java.util.UUID;

@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(generator="uuidgenerator")
    @GenericGenerator(name="uuidgenerator", strategy= "uuid2")
    @Column(name="id",columnDefinition = "binary(16)",nullable = false, updatable = false)
    private UUID uuid;
}
