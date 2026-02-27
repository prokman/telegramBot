package com.pharmBot.telegramBot.handlers;

public final class HandlerPriorities {
    private HandlerPriorities() {}

    public static final int FIND_MEDICINE_STATE = 100;
    public static final int REGULAR_COMMAND = 300;
    public static final int UNKNOWN_COMMAND = 900;

}
