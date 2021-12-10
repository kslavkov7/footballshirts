package com.example.shirts.util.event;

import org.springframework.context.ApplicationEvent;

public class InitEvent extends ApplicationEvent {
    public InitEvent(Object source) {
        super(source);
    }
}
