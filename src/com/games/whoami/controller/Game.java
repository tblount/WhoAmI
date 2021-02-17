package com.games.whoami.controller;

import com.apps.util.Prompter;
import com.games.whoami.Character;
import com.games.whoami.CharacterDatabase;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Prompter prompter;

    public Game(Prompter prompter) {
        this.prompter = prompter;
    }

    private GameHelper gameHelper = new GameHelper();

    public void run() throws IOException {

        //TODO: break down to private calls
        Character character = new CharacterDatabase();

        // creating random/mystery
        String mysteryPerson = character.randomPerson().getName();
        System.out.println("Assigned random person: " + mysteryPerson);

        Scanner input = new Scanner(System.in);

        // implement welcome method
        System.out.println(gameHelper.Welcome());

        System.out.println("\n" + "Starting the game now!\nHave a blast!");

        System.out.println("\n=================================================================================================" +
                "=============================================================================================\n" + gameHelper.listNames(character));

        while (character.size() != 1) {
            // make prompt calls
            prompter.prompt("Enter (1) to guess by Name or (2) to guess by Features!");   // This Line changed by Terrance to update using prompter
            //System.out.println("Enter (1) to guess by Name or (2) to guess by Features!");

            int nameOrFeature = input.nextInt();
            if (nameOrFeature == 1) {
                prompter.prompt("Make a choice from the list - " + gameHelper.listNames(character));
                //System.out.println("Make a choice from the list - " + gameHelper.listNames(character));
            }
            if (nameOrFeature == 2) {
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
            } /*else if (nameOrFeature == 1) {
                System.out.println("Please type the name of the person below: ");
                String name = input.nextLine();
                findByName(name, character);
            } else {
                System.out.println("Enter *1* to guess by Name or *2* to guess by Features!");
            }*/
        }
        System.out.println("Congratulations! You found your mystery character!");
    }
}