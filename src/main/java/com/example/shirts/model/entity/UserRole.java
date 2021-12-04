package com.example.shirts.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{
    private UserRoleEnum role;

    public UserRole() {
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
