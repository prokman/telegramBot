package com.pharmBot.telegramBot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class BaseHandler implements UpdateHandler {

    @Override
    public boolean canHandle(Update update) {
        if (!update.hasMessage()||!update.getMessage().hasText()) {
            return false;
        }
        return canHandleText(update);
    }

    protected abstract boolean canHandleText(Update update);

    @Override
    public int getPriority() {
        return HandlerPriorities.REGULAR_COMMAND;
    }

    protected Long getChatId(Update update) {
        return update.getMessage().getChatId();
    }

    protected Integer getMessageId(Update update) {
        return update.getMessage().getMessageId();
    }

    protected String getUserName(Update update) {
        return update.getMessage().getFrom().getUserName();
    }

    protected Long getUserId(Update update) {
        return update.getMessage().getFrom().getId();
    }

    protected String getMessageText(Update update) {
        return update.getMessage().getText();
    }


}
