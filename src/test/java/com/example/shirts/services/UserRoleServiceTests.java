package com.example.shirts.services;

import com.example.shirts.base.BaseTest;
import com.example.shirts.model.entity.User;
import com.example.shirts.model.entity.UserRole;
import com.example.shirts.repository.UserRepository;
import com.example.shirts.repository.UserRoleRepository;
import com.example.shirts.service.UserRoleService;
import com.example.shirts.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserRoleServiceTests extends BaseTest {
    private List <UserRole> userRoles;
    private UserRole userRole;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    ModelMapper modelMapper;
    @MockBean
    private UserRoleRepository userRoleRepository;

    @Before
    public void setupTest() {
        userRoles = new ArrayList<>();
        when(userRoleRepository.findAll())
                .thenReturn(userRoles);
        userRole = new UserRole();
        userRoles.add(userRole);
        when(userRoleRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(userRoles.get(0)));
    }

    @Test
    public void testFindRoleById(){
        Assert.assertEquals(userRoleService.findRoleById(1), userRole);
    }
}
