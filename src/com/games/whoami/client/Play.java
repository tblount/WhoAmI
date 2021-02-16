package com.games.whoami.client;

import com.apps.util.Prompter;
import com.games.whoami.controller.Game;

import java.io.IOException;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) throws IOException {
        // TODO: try catch exception
        Game game = new Game(new Prompter(new Scanner(System.in)));
        game.run();
    }
}