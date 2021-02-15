package com.games.whoami;

import java.util.Collection;

public interface Character {
    Collection<Person> filterByName(String name);

    Collection<Person> filterByHair(boolean hair);

    Collection<Person> filterByHairLength(HairLength hairLength);

    Collection<Person> filterByGlasses(boolean glasses);

    Collection<Person> filterByCover(boolean cover);

    Collection<Person> filterByBeard(boolean beard);

    int size();

    Collection<Person> getAll();

}