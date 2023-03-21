package com.discord.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

//@RefreshScope
@Component
@Getter @Setter
@ToString
public class Token {
    @Value("${discord.token}")
    private String token;
}
