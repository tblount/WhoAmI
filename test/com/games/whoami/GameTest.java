package com.games.whoami;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class GameTest {
    @Test
    public void playerSelection_shouldReturnString_whenSelectionValidInteger() {
        assertEquals("Hair", GameHelper.playerSelection(1));
        assertEquals("HairLength", GameHelper.playerSelection(2));
        assertEquals("Glasses", GameHelper.playerSelection(3));
        assertEquals("Cover", GameHelper.playerSelection(4));
        assertEquals("Beard", GameHelper.playerSelection(5));
    }

    @Test
    public void playerSelection_shouldReturnNull_whenSelectionInvalidInteger() {
        assertNull(GameHelper.playerSelection(0));
    }

    @Test
    public void playerOptionNames_shouldReturnFilteredNameList_whenListNotEmpty() throws IOException {
        Character character = new CharacterDatabase();
        List<String> hairList = GameHelper.playerOptionNames(character, 1, true);
        List<String> noBeardList = GameHelper.playerOptionNames(character, 5, false);
    }


}