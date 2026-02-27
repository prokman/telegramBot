package com.pharmBot.telegramBot.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pharmBot.telegramBot.model.ChannelHistory;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

import java.time.LocalDateTime;


@Service
@Slf4j
public class InitialDataLoader {
    private static final Logger logger = LoggerFactory.getLogger(InitialDataLoader.class);

    private ChannelHistory chanelHistory;

    public ChannelHistory getChanelHistory(){
        return chanelHistory;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadInitialData() {
        logger.trace("начало загрузки json файла");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .registerTypeAdapter(String.class, new TextAdapter())
                .create();

        try (FileReader reader = new FileReader("PharmaHistoryBase.json")) {
            chanelHistory = gson.fromJson(reader, ChannelHistory.class);
            //System.out.println("----debug: " + chanelHistory);

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Ошибка при загрузке JSON-файла", e);
        }
        logger.trace("загрузка json файла завершена");
    }
}
