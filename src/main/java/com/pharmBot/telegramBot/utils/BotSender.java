package com.pharmBot.telegramBot.utils;

import com.pharmBot.telegramBot.bot.PharmBot;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class BotSender {
    private final ApplicationContext context;

    public void sendMessage(Long chatId, String text) {
        sendMessage(chatId,text,null);

    }

    public void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .replyMarkup(replyKeyboard)
                .build();
        try {
            getBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private AbsSender getBot() {
        return context.getBean(PharmBot.class);
    }

}
