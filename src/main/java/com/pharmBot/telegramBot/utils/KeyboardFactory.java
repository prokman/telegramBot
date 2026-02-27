package com.pharmBot.telegramBot.utils;

import com.pharmBot.telegramBot.model.ButtonNames;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;
import java.util.List;

@Component
public class KeyboardFactory {
    public ReplyKeyboardMarkup createMainMenuKeyboard() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(ButtonNames.CHANNELSSEARCH.toString());
        row1.add(ButtonNames.REMINDER.toString());
        KeyboardRow row2 = new KeyboardRow();
        row2.add(ButtonNames.AIDKIT.toString());
        row2.add(ButtonNames.QUIZ.toString());

        List<KeyboardRow> keyboard = Arrays.asList(row1,row2);

        return ReplyKeyboardMarkup.builder()
                .keyboard(keyboard)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .selective(true)
                .build();
    }

    public InlineKeyboardMarkup createReminderMenuKeyboard() {
        InlineKeyboardButton button = InlineKeyboardButton.builder()
                .text("Button1").callbackData("but1")
                .build();
        InlineKeyboardButton button2 = InlineKeyboardButton.builder()
                .text("Button2").callbackData("but2")
                .build();
        InlineKeyboardButton button3 = InlineKeyboardButton.builder()
                .text("Button3").callbackData("but3")
                .build();
        InlineKeyboardButton button4 = InlineKeyboardButton.builder()
                .text("Button4").callbackData("but4")
                .build();
        return  InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(button, button2, button3, button4))
                //.keyboardRow(List.of(button2))
                .build();

    }


}
