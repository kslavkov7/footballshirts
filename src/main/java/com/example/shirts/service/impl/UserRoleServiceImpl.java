package com.example.shirts.service.impl;

import com.example.shirts.model.entity.UserRole;
import com.example.shirts.repository.UserRoleRepository;
import com.example.shirts.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole findRoleById(long l) {
        return userRoleRepository.findById(l).orElseThrow();
    }
}
