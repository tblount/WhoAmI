package com.games.whoami.client;

import com.apps.util.Prompter;
import com.apps.util.SplashApp;
import com.games.whoami.controller.Game;

import java.io.IOException;
import java.util.Scanner;

public class Play implements SplashApp {

    @Override
    public void start() {
        Game game = new Game();
        game.initialize();
    }
    public static void main(String[] args) {

        Play app = new Play();
        app.welcome("images/logo.jpg", "images/credits.png");
        app.start();
        try {
            Game game = new Game();
            Prompter prompter = new Prompter(new Scanner(System.in));
            game.run(prompter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}