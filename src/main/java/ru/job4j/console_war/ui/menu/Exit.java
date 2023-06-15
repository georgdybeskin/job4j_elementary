package ru.job4j.console_war.ui.menu;

import ru.job4j.console_war.ui.controller.ViewController;

public class Exit implements MenuItem {

    @Override
    public int execute(ViewController controller) {
        controller.exit();
        return 0;
    }

    @Override
    public String intro() {
        return String.format("%s", "Выход");
    }
}
