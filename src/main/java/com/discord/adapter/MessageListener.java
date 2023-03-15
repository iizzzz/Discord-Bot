package com.discord.adapter;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class MessageListener extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("MTA4NTU2MDU3Nzk3NzQ5NTYyMw.Gp40vv.8ayx6sPnvf8TIqR6EN3TYQsvF_c_QMx6cOgHDg").build();
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
                    event.getTextChannel().getName(),
                    event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }
    }
}
