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
            prompter.prompt("\nPlease enter (1) to guess by Name or (2) to guess by Features!\n");

            int nameOrFeature = input.nextInt();
            if (nameOrFeature == 1) {
                prompter.prompt("Make a choice from the list - ");
                gameHelper.printer.printList(gameHelper.listNames(character));
            } else if (nameOrFeature == 2) {
                System.out.println("Select one of the features by entering: " +
                        "\n 1 - Hair, 2 - HairLength, 3 - Glasses, 4 - Cover, 5 - Beard \n");

                int featureSelection = input.nextInt();
                System.out.println(gameHelper.playerSelection(featureSelection) + " selected.");

                if (featureSelection != 2) {
                    System.out.println("\nNow please write: (true) if your character has " + gameHelper.playerSelection(featureSelection)
                            + " or (false) if he/she doesn't.");

                    boolean playerInput = input.nextBoolean();
                    List<String> currentNames = gameHelper.playerOptionNames(character, featureSelection, playerInput);

                    System.out.println("\n**********\n" + currentNames + "\n**********\n");
                } else {
                    System.out.println("\n What is the hair length: " +
                            "\n 1 - Short, 2 - Medium, 3 - Long, 4 - Bald \n");
                    int playerInput = input.nextInt();
                    Collection<String> currentNames = gameHelper.listNames(character.filterByHairLength(gameHelper.hairSelection(playerInput)));

                    System.out.println("\n**********\n" + currentNames + "\n**********\n");
                }
            } else {
                prompter.prompt("\nEnter (1) to guess by Name or (2) to guess by Features!\n");
            }
        }
        System.out.println("Congratulations! You found your mystery character!");
    }

}