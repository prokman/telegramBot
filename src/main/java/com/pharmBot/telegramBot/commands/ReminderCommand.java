package com.pharmBot.telegramBot.commands;

import com.pharmBot.telegramBot.utils.BotSender;
import com.pharmBot.telegramBot.utils.KeyboardFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class ReminderCommand implements Command{
    private final BotSender sender;
    private final KeyboardFactory keyboardFactory;

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        sender.sendMessage(chatId,"Меню напоминаний", keyboardFactory.createReminderMenuKeyboard());
    }

    @Override
    public String getCommandIdentifier() {
        return "Напоминания";
    }
}
