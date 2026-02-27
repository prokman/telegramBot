package com.pharmBot.telegramBot.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserStateService {
    private final Set<Long> findingUsers = ConcurrentHashMap.newKeySet();
    private final Set<Long> setReminderUsers = ConcurrentHashMap.newKeySet();

    public void setFindingUsers (Long chatId, boolean status) {
        if (status) findingUsers.add(chatId);
        else findingUsers.remove(chatId);
    }

    public boolean isFinding(Long chatId) {
        return findingUsers.contains(chatId);
    }
}
