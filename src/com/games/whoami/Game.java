package com.games.whoami;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Character character = new CharacterDatabase();

        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the guess game: Who Am I?" +
                "\nRules: Each player take guesses until one of them reveals " +
                "\n the mystery person by feature or try guessing their name directly!" +
                "\nGood luck!");

        System.out.println("\n" +"Starting the game now!!\n Have a blast!");

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
                    System.out.println("\n What is the hair length: ");
                }
            } /*else if (nameOrFeature == 1) {
                System.out.println("Please type the name of the person below: ");
                String name = input.nextLine();
                findByName(name, character);
            } else {
                System.out.println("Enter *1* to guess by Name or *2* to guess by Features!");
            }*/
        }
    }

/*    public static void findByName(String name, Character character) {
        List<String> allnames = listNames(character);
        if (allnames.contains(name)) {
            System.out.println("Congratulations you found the character: " + name);
        } else {
            System.out.println("Please try again.");
        }
    }*/

    public static List<String> listNames(Character character) {
        List<String> names = new ArrayList<>();
        character.getAll().forEach(name -> {
            if (name.getName().length() > 0) {
                names.add(name.getName());
            }
        });

        return names;
    }

    public static String playerSelection(int selection) {
        String choice = null;
        switch (selection) {
            case 1:
                choice = "Hair";
                break;
            case 2:
                choice = "HairLength";
                break;
            case 3:
                choice = "Glasses";
                break;
            case 4:
                choice = "Cover";
                break;
            case 5:
                choice = "Beard";
                break;
        }
        return choice;
    }

    public static List<String> playerOptionNames(Character character, int selection, boolean playerInput) {
        List<String> names = new ArrayList<>();
        Collection<Person> people = null;
        switch (selection) {
            case 1:
                people = character.filterByHair(playerInput);
                break;
            case 3:
                people = character.filterByGlasses(playerInput);
                break;
            case 4:
                people = character.filterByCover(playerInput);
                break;
            case 5:
                people = character.filterByBeard(playerInput);
                break;
        }

        people.forEach(name -> {
            if (name.getName().length() > 0) {
                names.add(name.getName());
            }
        });
        return names;
    }
}