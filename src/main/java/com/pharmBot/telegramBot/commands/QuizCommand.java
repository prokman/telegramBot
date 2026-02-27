package com.pharmBot.telegramBot.commands;

import com.pharmBot.telegramBot.utils.BotSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class QuizCommand implements Command{
    private final BotSender sender;

    @Override
    public void execute(Update update) {
        sender.sendMessage(update.getMessage().getChatId(), "Получено: Викторина");
    }

    @Override
    public String getCommandIdentifier() {
        return "Викторина";
    }
}
