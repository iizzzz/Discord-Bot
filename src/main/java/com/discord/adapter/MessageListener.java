package com.discord.adapter;

import com.discord.config.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.security.auth.login.LoginException;

public class MessageListener extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Token.class);
        Token bean = ac.getBean(Token.class);

        JDA jda = JDABuilder.createDefault(String.valueOf(bean)).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.addEventListener(new MessageListener());
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n",
                    event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n",
                    event.getGuild().getName(),
                    event.getTextChannel().getName(),
                    event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }
    }
}
