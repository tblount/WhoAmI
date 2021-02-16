package com.games.whoami;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static com.games.whoami.GameHelper.*;

public class Game {
    public void run() throws IOException {

        Character character = new CharacterDatabase();

        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the guess game: Who Am I?" +
                "\nRules: Each player take guesses until one of them reveals " +
                "\nthe mystery person by feature or try guessing their name directly!" +
                "\nGood luck!");

        System.out.println("\n" + "Starting the game now!\nHave a blast!");

        System.out.println("\n***************\n" + listNames(character) + "\n***************\n");

        while (character.size() != 1) {
            System.out.println("Enter *1* to guess by Name or *2* to guess by Features!");

            int nameOrFeature = input.nextInt();
            if (nameOrFeature == 1) {
                System.out.println("Make a choice from the list - " + listNames(character));
            }
            if (nameOrFeature == 2) {
                System.out.println("Select one of the features by entering: " +
                        "\n 1 - Hair, 2 - HairLength, 3 - Glasses, 4 - Cover, 5 - Beard \n");

                int featureSelection = input.nextInt();
                System.out.println(playerSelection(featureSelection) + " selected.");

                if (featureSelection != 2) {
                    System.out.println("\nNow please write: *true* if your character has " + playerSelection(featureSelection)
                            + " or *false* if he/she doesn't.");

                    boolean playerInput = input.nextBoolean();
                    List<String> currentNames = playerOptionNames(character, featureSelection, playerInput);

                    System.out.println("\n**********\n" + currentNames + "\n**********\n");
                } else {
                    System.out.println("\n What is the hair length: " +
                            "\n 1 - Short, 2 - Medium, 3 - Long, 4 - Bald \n");
                    int playerInput = input.nextInt();
                    Collection<String> currentNames = listNames(character.filterByHairLength(HairLength.select(playerInput)));

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