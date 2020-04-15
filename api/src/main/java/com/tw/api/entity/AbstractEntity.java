package com.tw.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @JsonIgnore
    @Transient
    @org.springframework.data.annotation.Transient
    protected boolean isNew;

    @Column(nullable = false, unique = true)
    protected String name;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public boolean getIsNew() {
        return this.isNew = (this.id == null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
