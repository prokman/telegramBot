package com.pharmBot.telegramBot.service;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.util.stream.Collectors;


import java.lang.reflect.Type;

public class TextAdapter implements JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            return jsonElement.getAsString();
        } else {
//            JsonElement textElement = jsonElement.getAsJsonObject().get("text");
            if (jsonElement.isJsonArray()) {
                return jsonElement
                        .getAsJsonArray()
                        .asList()
                        .stream()
                        .map(je -> {
                            if (je.isJsonObject()) {return je.getAsJsonObject().get("text").getAsString();}
                            else {return je.getAsString();}
                        })
                        .collect(Collectors.joining("\n"));
            } else {
                return jsonElement.toString();
            }

        }
    }
}
