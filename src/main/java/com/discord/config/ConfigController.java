package com.discord.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RefreshScope
@RestController
public class ConfigController {

    private final Token token;

    public ConfigController(Token token) {
        this.token = token;
    }


    @GetMapping("/test")
    public String config() {
        System.out.println(token);
        return token.toString();
    }
}
