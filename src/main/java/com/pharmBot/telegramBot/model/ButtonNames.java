package com.pharmBot.telegramBot.model;

public enum ButtonNames {
    CHANNELSSEARCH("Поиск"),
    REMINDER("Напоминания"),
    AIDKIT("Аптечка"),
    QUIZ("Викторина");

    private String value;

    private ButtonNames(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
