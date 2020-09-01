package com.text.command;

public class CommandFactory {
    public static Command createCommand(String commandT){
        switch (commandT) {
            case"command_create_text":
                return new CreateText();
            case "command_read_text":
                return new ReadText();
            default:
                return null;
        }
    }
}
