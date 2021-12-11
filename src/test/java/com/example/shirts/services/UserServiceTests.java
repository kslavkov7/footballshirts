package com.example.shirts.services;

import com.example.shirts.base.BaseTest;
import com.example.shirts.model.entity.User;
import com.example.shirts.model.entity.UserRole;
import com.example.shirts.model.view.UserView;
import com.example.shirts.repository.UserRepository;
import com.example.shirts.repository.UserRoleRepository;
import com.example.shirts.service.UserService;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.Mockito.when;

public class UserServiceTests extends BaseTest {
    private List<User> usersList;
    private List <UserRole> userRoles;

    @Autowired
    private UserService userService;
    @Autowired
    ModelMapper modelMapper;
    @MockBean
    private UserRepository userRepository;

    @Before
    public void setupTest() {
        usersList = new ArrayList<>();
        when(userRepository.findAll())
                .thenReturn(usersList);

    }

    @Test
    public void testGetAllUsersWhenUserListEmptyShouldReturnEmpty(){
        usersList.clear();
        List <UserView> userViewList =  userService.getAllUsers();
        Assert.assertEquals(0, userViewList.size());
    }

    @Test
    public void testGetAllUsersWhenUserListNotEmptyShouldReturnUsers(){
        usersList.clear();
        User user = new User();
        usersList.add(user);
        List <UserView> userViewList =  userService.getAllUsers();
        Assert.assertEquals(1, userViewList.size());
    }

    @Test
    public void testIsEmptyWhenUserListEmptyShouldReturnTrue(){
        usersList.clear();
        boolean result =  userService.isEmpty();
        Assert.assertTrue(result);
    }











}
