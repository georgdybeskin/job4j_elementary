package ru.job4j.console_war.ui.menu;

import ru.job4j.console_war.ui.controller.ViewController;

import java.util.Arrays;

import static ru.job4j.console_war.RunApp.validator;

public class CreateDarkSquad implements MenuItem {

    @Override
    public int execute(ViewController controller) {
        int choice = validator.getIntFromList("Выберите отряд 1 - Орки, 2 - Нежить: ", Arrays.asList(1, 2));
        controller.createDarkSquad(choice);
        return 1;
    }

    @Override
    public String intro() {
        return String.format("%s", "Создать отряд для тёмной стороны");
    }
}
