package com.pharmBot.telegramBot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateHandler extends PriorityHandler{
    boolean canHandle(Update update);
    void handle(Update update);
}
