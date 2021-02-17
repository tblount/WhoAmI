package com.games.whoami.controller;


import com.games.whoami.Character;
import com.games.whoami.HairLength;
import com.games.whoami.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class GameHelper {
    Printer printer = new Printer();

    GameHelper() throws IOException {
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

        void printList(List<String> names) {
            names.forEach(System.out::println);
        }
    }
}