package com.games.whoami.controller;

import com.games.whoami.Character;
import com.games.whoami.CharacterDatabase;
import com.games.whoami.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;

public class GameTest {
    GameHelper gameHelper;

    @Before
    public void init() throws IOException {
        gameHelper = new GameHelper();
    }

    @Test
    public void playerSelection_shouldReturnString_whenSelectionValidInteger() {
        assertEquals("Hair", gameHelper.playerSelection(1));
        assertEquals("HairLength", gameHelper.playerSelection(2));
        assertEquals("Glasses", gameHelper.playerSelection(3));
        assertEquals("Cover", gameHelper.playerSelection(4));
        assertEquals("Beard", gameHelper.playerSelection(5));
    }

    @Test
    public void playerSelection_shouldReturnNull_whenSelectionInvalidInteger() {
        assertNull(gameHelper.playerSelection(0));
    }

    @Test
    public void playerOptionNames_shouldReturnFilteredNameList_whenListNotEmpty() throws IOException {
        Character character = new CharacterDatabase();
        Collection<Person> hairList = gameHelper.playerOptionNames(character, 1, true);
        Collection<Person> noBeardList = gameHelper.playerOptionNames(character, 5, false);
    }
}