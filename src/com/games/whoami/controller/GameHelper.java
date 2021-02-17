package com.games.whoami.controller;

import com.games.whoami.Character;
import com.games.whoami.HairLength;
import com.games.whoami.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameHelper {

    public String Welcome() {
        System.out.println("\nWelcome to the guess game: Who Am I?" +
                "\nRules: The player will take a guess until the player reveals " +
                "\nthe mystery person by guessing a feature or their name directly!" +
                "\nGood luck!");
        return String.valueOf(0);
    }

    public String playerSelection(int selection) {
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

    public List<String> playerOptionNames(Character character, int selection, boolean playerInput) {
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

    public HairLength hairSelection(int selection) {
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

    public List<String> listNames(Character character) {
        return listNames(character.getAll());
    }

    public List<String> listNames(Collection<Person> persons) {
        List<String> names = new ArrayList<>();
        persons.forEach(name -> {
            if (name.getName().length() > 0) {
                names.add(name.getName());
            }
        });
        return names;
    }
}