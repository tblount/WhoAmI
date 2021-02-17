package com.games.whoami.controller;

import com.games.whoami.Character;
import com.games.whoami.CharacterDatabase;

import java.io.IOException;

public class Game {
    GameHelper gameHelper = new GameHelper();

    public Game() throws IOException {
    }

    public void run() throws IOException {

        //TODO: break down to private calls
        Character character = new CharacterDatabase();

        // creating random/mystery
        String mysteryPerson = character.randomPerson().getName();
        System.out.println("Assigned random person: " + mysteryPerson);

        // implement welcome method
        gameHelper.printer.welcome();
        gameHelper.printer.printList(gameHelper.listNames(character));
        gameHelper.gameLogic(mysteryPerson);
        gameHelper.printer.win(mysteryPerson);
    }
}