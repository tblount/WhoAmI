package com.games.whoami;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class GameTest {
    @Test
    public void playerSelection_shouldReturnString_whenSelectionValidInteger(){
        assertEquals("Hair",Game.playerSelection(1));
        assertEquals("HairLength",Game.playerSelection(2));
        assertEquals("Glasses",Game.playerSelection(3));
        assertEquals("Cover",Game.playerSelection(4));
        assertEquals("Beard",Game.playerSelection(5));
    }
    @Test
    public void playerSelection_shouldReturnNull_whenSelectionInvalidInteger(){
        assertNull(Game.playerSelection(0));
    }
    @Test
    public void playerOptionNames_shouldReturnFilteredNameList_whenListNotEmpty() throws IOException {
        Character character = new CharacterDatabase();
        List<String> hairList = Game.playerOptionNames(character,1,true);
        List<String> noBeardList = Game.playerOptionNames(character,5,false);
    }


}