package com.games.whoami.controller;

import com.apps.util.Prompter;
import com.games.whoami.Character;
import com.games.whoami.CharacterDatabase;
import com.games.whoami.HairLength;
import com.games.whoami.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import java.util.stream.Collectors;

class GameHelper {
    Printer printer = new Printer();

    GameHelper() throws IOException {
    }

    Character character = new CharacterDatabase();
    private Prompter prompter = new Prompter(new Scanner(System.in));

    void gameLogic(String mysteryPerson) {
        while (character.size() != 1) {
            // make prompt calls
            String nameOrFeature = prompter.prompt("\nPlease enter (1) to guess by Name or (2) to guess by Features!\n",
                    "[1-2]", "Not Valid Answer, Try Again");

            if (nameOrFeature.equals("1")) {
                printer.printList(listNames(character));
                String name = prompter.prompt("\nPlease enter the name from the list:\n");
                if (mysteryPerson.equalsIgnoreCase(name)) {
                    break;
                }
            } else {

                String featureSelected = prompter.prompt("Select one of the features by entering: " +
                        "\n1 - Hair, 2 - HairLength, 3 - Glasses, 4 - Cover, 5 - Beard \n", "[1-5]", "Invalid Entry, Try Again");
                int featureSelection = Integer.parseInt(featureSelected);

                printer.choice(playerSelection(featureSelection));

                if (featureSelection != 2) {
                    String playerChoice = prompter.prompt("\nNow please write: (true) if you think your character has " +
                            playerSelection(featureSelection)
                            + " or (false) if he/she doesn't.\n", "true|false|True|False", "Invalid Entry, Try Again!");
                    boolean playerInput = Boolean.parseBoolean(playerChoice);
                    List<String> currentNames = playerOptionNames(character, featureSelection, playerInput);
                    printer.printList(currentNames);
                } else {
                    String playerChoice = prompter.prompt("\n What is the hair length: "
                                    + "\n 1 - Short, 2 - Medium, 3 - Long, 4 - Bald \n"
                            , "[1-4]", "Invalid Entry, Try Again!");
                    int playerInput = Integer.parseInt(playerChoice);
                    List<String> currentNames = listNames(character.filterByHairLength(hairSelection(playerInput)));
                    printer.printList(currentNames);
                }
            }
        }
    }

    String playerSelection(int selection) {
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

    List<String> playerOptionNames(Character character, int selection, boolean playerInput) {
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
        return listNames(people);
    }

    HairLength hairSelection(int selection) {
        HairLength hairLength = null;
        switch (selection) {
            case 1:
                hairLength = HairLength.SHORT;
                break;
            case 2:
                hairLength = HairLength.MEDIUM;
                break;
            case 3:
                hairLength = HairLength.LONG;
                break;
            case 4:
                hairLength = HairLength.BALD;
                break;
        }
        return hairLength;
    }

    List<String> listNames(Character character) {
        return listNames(character.getAll());
    }

    List<String> listNames(Collection<Person> persons) {
        List<String> names = new ArrayList<>();
        persons.forEach(name -> {
            if (name.getName().length() > 0) {
                names.add(name.getName());
            }
        });
        return names;
    }

    //InnerClass

    class Printer {
        Path dataFilePath;
        List<String> messages;

        Printer() throws IOException {
            this.dataFilePath = Path.of("data/messages.csv");
            this.messages = Files.lines(dataFilePath).collect(Collectors.toList());
        }

        void welcome() {
            Arrays.stream(messages.get(0).split("/n")).forEach(System.out::println);
            Arrays.stream(messages.get(1).split("/n")).forEach(System.out::println);
        }

        void printList(Collection<String> names) {
            names.forEach(System.out::println);
        }

        void choice(String selected) {
            System.out.println(selected + " selected.");
        }

        void win(String mysteryPerson) {
            System.out.println("Congratulations! You found the Mystery Character: " + mysteryPerson);
        }
    }
}