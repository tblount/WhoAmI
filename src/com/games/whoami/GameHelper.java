package com.games.whoami;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameHelper {
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

    public static List<String> listNames(Character character) {
        return listNames(character.getAll());
    }

    public static List<String> listNames(Collection<Person> persons) {
        List<String> names = new ArrayList<>();
        persons.forEach(name -> {
            if (name.getName().length() > 0) {
                names.add(name.getName());
            }
        });
        return names;
    }
}