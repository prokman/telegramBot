package com.pharmBot.telegramBot.commands;

import com.pharmBot.telegramBot.utils.BotSender;
import com.pharmBot.telegramBot.utils.KeyboardFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command {
    private final BotSender sender;
    private final KeyboardFactory keyboardFactory;

    @Override
    public void execute(Update update) {
        long chatId = update.getMessage().getChatId();
        sender.sendMessage(chatId, "Выберите действие:",keyboardFactory.createMainMenuKeyboard());
    }

    @Override
    public String getCommandIdentifier() {
        return "/start";
    }
}
