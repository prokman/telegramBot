package com.pharmBot.telegramBot.commands;

import com.pharmBot.telegramBot.utils.BotSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class UnknownCommand implements Command {
    private final BotSender sender;

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        sender.sendMessage(chatId, "Неизвестная команда. Воспользуйтесь меню.");
    }

    @Override
    public String getCommandIdentifier() {
        return "UnknownCommand";
    }
}
