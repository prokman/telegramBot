package com.pharmBot.telegramBot.handlers;

import com.pharmBot.telegramBot.commands.ProccessFindMedicineCommand;
import com.pharmBot.telegramBot.service.UserStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class FindMedicineHandler extends BaseHandler {
    private final UserStateService userStateService;
    private final ProccessFindMedicineCommand proccessFindMedicineCommand;

    @Override
    protected boolean canHandleText(Update update) {
        Long chatId = getChatId(update);
        boolean isFinding = userStateService.isFinding(chatId);
        return isFinding;
    }

    @Override
    public int getPriority() {
        return HandlerPriorities.FIND_MEDICINE_STATE;
    }


    @Override
    public void handle(Update update) {

        proccessFindMedicineCommand.execute(update);
    }
}
