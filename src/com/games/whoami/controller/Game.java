package com.games.whoami.controller;

import com.apps.util.Prompter;
import com.games.whoami.Character;
import com.games.whoami.CharacterDatabase;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Prompter prompter = new Prompter(new Scanner(System.in));

    GameHelper gameHelper = new GameHelper();

    public Game() throws IOException {
    }

    public void run() throws IOException {

        //TODO: break down to private calls
        Character character = new CharacterDatabase();

        // creating random/mystery
        String mysteryPerson = character.randomPerson().getName();
        System.out.println("Assigned random person: " + mysteryPerson);

        Scanner input = new Scanner(System.in);

        // implement welcome method
        gameHelper.printer.welcome();
        gameHelper.printer.printList(gameHelper.listNames(character));

        while (character.size() != 1) {
            // make prompt calls
            String nameOrFeature = prompter.prompt("\nPlease enter (1) to guess by Name or (2) to guess by Features!\n",
                    "[1-2]","Not Valid Answer, Try Again");

            if (nameOrFeature.equals("1")) {
                gameHelper.printer.printList(gameHelper.listNames(character));
                String name = prompter.prompt("Make a choice from the list - \n");
                if (mysteryPerson.equalsIgnoreCase(name)){
                    break;
                }
            } else {

                String featureSelected = prompter.prompt("Select one of the features by entering: " +
                        "\n 1 - Hair, 2 - HairLength, 3 - Glasses, 4 - Cover, 5 - Beard \n","[1-5]","Invalid Entry, Try Again");
                int featureSelection = Integer.parseInt(featureSelected);

                gameHelper.printer.choice(gameHelper.playerSelection(featureSelection));

                if (featureSelection != 2) {
                    String playerChoice = prompter.prompt("\nNow please write: (true) if you think your character has " +
                            gameHelper.playerSelection(featureSelection)
                            + " or (false) if he/she doesn't.\n","true|false|True|False","Invalid Entry, Try Again!");
                    boolean playerInput = Boolean.parseBoolean(playerChoice);
                    List<String> currentNames = gameHelper.playerOptionNames(character, featureSelection, playerInput);
                    gameHelper.printer.printList(currentNames);
                } else {
                    String playerChoice = prompter.prompt("\n What is the hair length: "
                                    + "\n 1 - Short, 2 - Medium, 3 - Long, 4 - Bald \n"
                                    ,"[1-4]","Invalid Entry, Try Again!");
                    int playerInput = Integer.parseInt(playerChoice);
                    List<String> currentNames = gameHelper.listNames(character.filterByHairLength(gameHelper.hairSelection(playerInput)));
                    gameHelper.printer.printList(currentNames);
                }
            }
        }
        gameHelper.printer.win(mysteryPerson);
    }

}