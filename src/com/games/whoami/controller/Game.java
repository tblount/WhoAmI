/**
 *
 */
package com.games.whoami.controller;

import com.apps.util.Prompter;
import com.games.whoami.Character;
import com.games.whoami.CharacterDatabase;

import java.io.IOException;

public class Game {
    GameHelper gameHelper = new GameHelper();

    public Game() throws IOException {
    }

    public void run(Prompter prompter) throws IOException {

        Character character = new CharacterDatabase();

        // creating random/mystery
        String mysteryPerson = character.randomPerson().getName();
        System.out.println("Assigned random person: " + mysteryPerson);

        gameHelper.printer.welcome();
        gameHelper.printer.printList(gameHelper.listNames(character));
        gameHelper.gameLogic(mysteryPerson, prompter);
        gameHelper.win(mysteryPerson);
    }

}