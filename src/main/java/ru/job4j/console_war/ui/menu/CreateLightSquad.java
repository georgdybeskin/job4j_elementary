package ru.job4j.console_war.ui.menu;

import ru.job4j.console_war.ui.controller.ViewController;

import java.util.Arrays;

import static ru.job4j.console_war.RunApp.validator;

public class CreateLightSquad implements MenuItem {

    @Override
    public int execute(ViewController controller) {
        int choice = validator.getIntFromList("Выберите отряд 1 - Люди, 2 - Эльфы: ", Arrays.asList(1, 2));
        controller.createLightSquad(choice);
        return 1;
    }

    @Override
    public String intro() {
        return String.format("%s", "Создать отряд для светлой стороны");
    }
}
