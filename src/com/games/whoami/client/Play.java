package com.games.whoami.client;

import com.apps.util.Prompter;
import com.games.whoami.controller.Game;

import java.io.IOException;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            Prompter prompter = new Prompter(new Scanner(System.in));
            game.run(prompter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}