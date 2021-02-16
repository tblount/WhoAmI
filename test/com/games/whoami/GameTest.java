package com.games.whoami;

import com.games.whoami.controller.Game;
import com.games.whoami.controller.GameHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

public class GameTest {
    GameHelper gameHelper;

    @Before
    public void init() {
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
        List<String> hairList = gameHelper.playerOptionNames(character, 1, true);
        List<String> noBeardList = gameHelper.playerOptionNames(character, 5, false);
    }
}