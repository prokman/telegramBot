package com.pharmBot.telegramBot.commands;

import com.pharmBot.telegramBot.service.FindMedicineService;
import com.pharmBot.telegramBot.service.UserStateService;
import com.pharmBot.telegramBot.utils.BotSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class FindMedicineCommand implements Command {
    private final BotSender sender;
    private final FindMedicineService findMedicineService;
    private final UserStateService userStateService;

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        userStateService.setFindingUsers(chatId,true);
        sender.sendMessage(chatId, "Введите текст для поиска на канале.\nНапример название лекарства");
    }

    @Override
    public String getCommandIdentifier() {
        return "Поиск";
    }
}
