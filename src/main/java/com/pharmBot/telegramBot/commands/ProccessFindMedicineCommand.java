package com.pharmBot.telegramBot.commands;

import com.pharmBot.telegramBot.service.FindMedicineService;
import com.pharmBot.telegramBot.service.UserStateService;
import com.pharmBot.telegramBot.utils.BotSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class ProccessFindMedicineCommand implements Command {
    private final BotSender sender;
    private final FindMedicineService findMedicineService;
    private final UserStateService userStateService;

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();

        if (messageText.length()<4||messageText.isBlank()) {
            sender.sendMessage(chatId,"Текст для поиска должен быть длиннее 4 символов и не должен состоять " +
                    "только из пробелов.\n\nПопробуйте еще раз ввести текст для поиска на канале");
            return;
        }
        String result = findMedicineService.findMedicine(messageText);
        String response = result == null||result.isBlank()
                ?"Поиск не дал результата"
                :"Вот что нашлось:\n\n"+result;
        sender.sendMessage(chatId,response);
        userStateService.setFindingUsers(chatId,false);
    }

    @Override
    public String getCommandIdentifier() {
        return "ProccessFindMedicineCommand";
    }
}
