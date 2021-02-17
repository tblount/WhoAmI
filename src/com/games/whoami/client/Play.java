package com.games.whoami.client;
import com.games.whoami.controller.Game;
import java.io.IOException;

public class Play {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}