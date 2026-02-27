package com.pharmBot.telegramBot.service;

import com.pharmBot.telegramBot.model.ChannelHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FindMedicineService {
    private final InitialDataLoader initialDataLoader;
    private final int FIRSTSTRINGLINE=0;


    public String findMedicine(String medicineName) {

        ChannelHistory history = initialDataLoader.getChanelHistory();
        if (history == null) {
            System.out.println("Загрузка не удалась");
        }
        //https://t.me/zapisky_aptekarya/###
        StringBuilder stringBuilder = new StringBuilder();
        history.getMessages()
                .stream()
                .forEach(message -> {
                    if (message.getText().toLowerCase().contains(medicineName.toLowerCase())) {
                        stringBuilder.append("https://t.me/zapisky_aptekarya/")
                                .append(message.getId())
                                .append("\n")
                                .append(message.getText().split("\n", 2)[FIRSTSTRINGLINE])
                                .append("\n\n");
                    }
                });
        return stringBuilder.toString();
    }

}
