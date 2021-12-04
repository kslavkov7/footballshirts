package com.example.shirts.repository;

import com.example.shirts.model.entity.UserRole;
import com.example.shirts.model.entity.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findByRole(UserRoleEnum role);
}
