package com.pharmBot.telegramBot.handlers;

import com.pharmBot.telegramBot.commands.Command;
import com.pharmBot.telegramBot.commands.CommandContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class RegularCommandHandler extends BaseHandler{
    private final CommandContainer commandContainer;

    @Override
    protected boolean canHandleText(Update update) {
        return true;
    }

    @Override
    public int getPriority() {
        return HandlerPriorities.REGULAR_COMMAND;
    }

    @Override
    public void handle(Update update) {
        Command command = commandContainer.retrieve(getMessageText(update));
        command.execute(update);
    }
}
