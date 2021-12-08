package com.example.shirts.model.view;

public class UserView {
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private String role;
    private boolean canPromote;
    private boolean canDemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isCanPromote() {
        return canPromote;
    }

    public void setCanPromote(boolean canPromote) {
        this.canPromote = canPromote;
    }

    public boolean isCanDemote() {
        return canDemote;
    }

    public void setCanDemote(boolean canDemote) {
        this.canDemote = canDemote;
    }
}
