package com.pharmBot.telegramBot.bot;

import com.pharmBot.telegramBot.handlers.UpdateHandlerChain;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.List;

@Component

@Primary
public class PharmBot extends TelegramLongPollingBot {
//    private final KeyboardFactory keyboardFactory;
//    private final CommandContainer commandContainer;
//    private final UserStateService userStateService;
//    private final ProccessFindMedicineCommand proccessFindMedicineCommand;
//    private final FindMedicineService findMedicineService;
    private String botUsername;
    private final UpdateHandlerChain handlerChain;

    public PharmBot(
            @Value("${bot.token}") String botToken,
            @Value("${bot.name}") String botUsername,
//            FindMedicineService findMedicineService,
//            KeyboardFactory keyboardFactory,
//            UserStateService userStateService,
//            ProccessFindMedicineCommand proccessFindMedicineCommand,
//            CommandContainer commandContainer,
            UpdateHandlerChain HandlerChain) {
        super(botToken);
        this.botUsername = botUsername;
//        this.findMedicineService = findMedicineService;
//        this.keyboardFactory = keyboardFactory;
//        this.commandContainer = commandContainer;
//        this.proccessFindMedicineCommand = proccessFindMedicineCommand;
//        this.userStateService = userStateService;
        this.handlerChain=HandlerChain;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("bot name-" + botUsername);
//        System.out.println("botToken-" + (botToken != null ? "ok" : "not set"));
//        testBotConnection();
//
//    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void onRegister() {
        super.onRegister();
        System.out.println("---------------Bot registered tg API -------------------------");
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Update received: " + update.getUpdateId());
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            String messageText = update.getMessage().getText();
//            Long chatId = update.getMessage().getChatId();
//            if (userStateService.isFinding(chatId)) {
//                proccessFindMedicineCommand.execute(update);
//                return;
//            }
//            Command command = commandContainer.retrieve(messageText);
//            command.execute(update);
//        }
        try {
            handlerChain.handleUpdate(update);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
