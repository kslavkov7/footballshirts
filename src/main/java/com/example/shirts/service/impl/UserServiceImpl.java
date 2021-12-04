package com.example.shirts.service.impl;

import com.example.shirts.model.entity.User;
import com.example.shirts.model.entity.UserRole;
import com.example.shirts.model.entity.UserRoleEnum;
import com.example.shirts.model.service.UserRegisterServiceModel;
import com.example.shirts.repository.UserRepository;
import com.example.shirts.repository.UserRoleRepository;
import com.example.shirts.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ShirtsUserServiceImpl shirtsUserService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository, ShirtsUserServiceImpl shirtsUserService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.shirtsUserService = shirtsUserService;
    }


    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegistrationServiceModel) {

        UserRole userRole = userRoleRepository.findByRole(UserRoleEnum.USER);
        User newUser = new User();

        newUser.setUsername(userRegistrationServiceModel.getUsername());
        newUser.setFullName(userRegistrationServiceModel.getFullName());
        newUser.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));
        newUser.setEmail(userRegistrationServiceModel.getEmail());
        newUser.getRoles().add(userRole);
        newUser = userRepository.save(newUser);

        // this is the Spring representation of a user
        UserDetails principal = shirtsUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    @Override
    public User findLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByUsername(username).orElse(null);

    }


    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRole adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
            UserRole moderatorRole = userRoleRepository.findByRole(UserRoleEnum.MODERATOR);
            UserRole userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("admin@admin");
            admin.setFullName("Admin Adminov");
            admin.setRoles(Set.of(adminRole, moderatorRole, userRole));
            userRepository.save(admin);

            User moderator = new User();
            moderator.setUsername("moderator");
            moderator.setPassword(passwordEncoder.encode("moderator"));
            moderator.setEmail("mod@mod");
            moderator.setFullName("Moderator");
            moderator.setRoles(Set.of(moderatorRole, userRole));
            userRepository.save(moderator);

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setEmail("user@user");
            user.setFullName("User Userov");
            user.setRoles(Set.of(userRole));
            userRepository.save(user);

        }
    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRole moderatorRole = new UserRole();
            moderatorRole.setRole(UserRoleEnum.MODERATOR);

            UserRole userRole = new UserRole();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, moderatorRole, userRole));
        }
    }
}
