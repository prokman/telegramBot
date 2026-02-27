package com.pharmBot.telegramBot.commands;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandContainer {
    private Map<String, Command> commandMap;
    private final List<Command> commands;
    private final Command unknownCommand;

    public CommandContainer(List<Command> commands, UnknownCommand unknownCommand) {
        this.commands = commands;
        this.unknownCommand = unknownCommand;
    }

    @PostConstruct
    public void init() {
        commandMap = new HashMap<>();
        for (Command command : commands) {
            if (!(command instanceof UnknownCommand)) {
                commandMap.put(command.getCommandIdentifier(), command);
            }
        }
    }

    public Command retrieve(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
