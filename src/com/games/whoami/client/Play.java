package com.games.whoami.client;

import com.games.whoami.Game;

import java.io.IOException;

public class Play {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }
}