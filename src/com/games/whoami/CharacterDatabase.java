package com.games.whoami;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterDatabase implements Character {
    private List<Person> characterDB = Arrays.asList(
            new Person("Mahatma Gandi", false, HairLength.BOLD, true, false, false),
            new Person("Muhammad Ali", true, HairLength.SHORT, false, false, false),
            new Person("Marilyn Monroe", true, HairLength.MEDIUM, false, false, false),
            new Person("Abraham Lincoln", true, HairLength.SHORT, false, true, true),
            new Person("Mother Teresa", true, HairLength.LONG, false, true, false),
            new Person("Charles Darwin", false, HairLength.BOLD, false, false, true),
            new Person("Queen Victoria", true, HairLength.LONG, false, true, false),
            new Person("Leonardo da Vinci", false, HairLength.BOLD, false, false, true),
            new Person("Franklin Roosevelt", true, HairLength.SHORT, true, false, false),
            new Person("JK Rowling", true, HairLength.LONG, false, false, false)
    );

    Collection<Person> people;

    @Override
    public Collection<Person> filterByName(String name) {
        people = characterDB.stream()
                .filter(chars -> chars.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return people;
    }

    @Override
    public Collection<Person> filterByHair(boolean hair) {
        people = characterDB.stream()
                .filter(chars -> chars.hasHair() == hair)
                .collect(Collectors.toList());
        return people;
    }

    @Override
    public Collection<Person> filterByHairLength(HairLength hairLength) {
        people = characterDB.stream()
                .filter(chars -> chars.getHairLength().equals(hairLength))
                .collect(Collectors.toList());
        return people;
    }

    @Override
    public Collection<Person> filterByGlasses(boolean glasses) {
        people = characterDB.stream()
                .filter(chars -> chars.hasGlasses() == glasses)
                .collect(Collectors.toList());
        return people;
    }

    @Override
    public Collection<Person> filterByCover(boolean cover) {
        people = characterDB.stream()
                .filter(chars -> chars.hasCover() == cover)
                .collect(Collectors.toList());
        return people;
    }

    @Override
    public Collection<Person> filterByBeard(boolean beard) {
        people = characterDB.stream()
                .filter(chars -> chars.hasBeard() == beard)
                .collect(Collectors.toList());
        return people;
    }

    @Override
    public int size() {
        return characterDB.size();
    }

    @Override
    public Collection<Person> getAll() {
        return Collections.unmodifiableCollection(characterDB);
    }
}