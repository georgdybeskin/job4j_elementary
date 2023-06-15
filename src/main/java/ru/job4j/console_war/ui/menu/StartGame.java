package ru.job4j.console_war.ui.menu;

import ru.job4j.console_war.ui.controller.ViewController;

public class StartGame implements MenuItem {

    @Override
    public int execute(ViewController controller) {
        return controller.startGame();
    }

    @Override
    public String intro() {
        return String.format("%s", "Начать игру");
    }
}
