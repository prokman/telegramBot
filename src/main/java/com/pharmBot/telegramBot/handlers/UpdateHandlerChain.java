package com.pharmBot.telegramBot.handlers;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Comparator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateHandlerChain {
    private final List<UpdateHandler> handlers;
    private List<UpdateHandler> sortedHandlers;

    @PostConstruct
    public void init() {
        this.sortedHandlers = handlers.stream()
                .sorted((Comparator.comparingInt(UpdateHandler::getPriority)))
                .toList();
    }

    public void handleUpdate(Update update) {
        if (update==null) {
            System.out.println("Получен null update");
            return;
        }

        for (UpdateHandler handler : sortedHandlers) {
            try {
                if (handler.canHandle(update)) {
                    handler.handle(update);
                    return;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("нет обработчиков для update: "+update.getUpdateId());
    }
}
