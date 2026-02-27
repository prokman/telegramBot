package com.pharmBot.telegramBot.handlers;

import com.pharmBot.telegramBot.commands.UnknownCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class UnknownCommandHandler extends BaseHandler {
    private final UnknownCommand unknownCommand;

    @Override
    protected boolean canHandleText(Update update) {
        return true;
    }

    @Override
    public int getPriority() {
        return HandlerPriorities.UNKNOWN_COMMAND;
    }

    @Override
    public void handle(Update update) {
        unknownCommand.execute(update);
    }
}
