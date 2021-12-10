package com.example.shirts.service.eventListener;

import com.example.shirts.service.ProductService;
import com.example.shirts.service.PurchaseService;
import com.example.shirts.service.TeamService;
import com.example.shirts.service.UserService;
import com.example.shirts.util.event.InitEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitData {
    private final UserService userService;

    public InitData(UserService userService) {
        this.userService = userService;
    }

    @EventListener(InitEvent.class)
    public void onAppStart(){
        if (userService.isEmpty()){
            userService.initializeUsersAndRoles();
        }
    }
}
