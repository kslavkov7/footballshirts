package com.example.shirts.service;

import com.example.shirts.model.entity.User;
import com.example.shirts.model.service.UserRegisterServiceModel;
import com.example.shirts.model.view.UserView;

import java.util.List;

public interface UserService {
    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);

    void initializeUsersAndRoles();

    User findLoggedInUser();

    List<UserView> getAllUsers();

    void promoteUser(Long id);

    void demoteUser(Long id);
}
