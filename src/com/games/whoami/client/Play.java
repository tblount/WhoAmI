package com.games.whoami.client;

import com.apps.util.Prompter;
import com.apps.util.SplashApp;
import com.games.whoami.controller.Game;

import java.io.IOException;
import java.util.Scanner;

public class Play implements SplashApp {
    Play() {

    }

    @Override
    public void start() {
        try {
            Game game = new Game();
            Prompter prompter = new Prompter(new Scanner(System.in));
            game.run(prompter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
        Play app = new Play();
        app.welcome("images/java.png" ,"images/credits.jpg");
        app.start();
    }
}