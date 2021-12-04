package com.example.shirts.service;

import com.example.shirts.model.entity.User;
import com.example.shirts.model.service.UserRegisterServiceModel;

public interface UserService {
    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);

    void initializeUsersAndRoles();

    User findLoggedInUser();


}
