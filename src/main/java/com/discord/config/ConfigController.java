package com.discord.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@RefreshScope
public class ConfigController {

    @Value("${discord.token}")
    private String token;

    @GetMapping("/test")
    public String config() {
        System.out.println(token);
        return token;
    }
}
