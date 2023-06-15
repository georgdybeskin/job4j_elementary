package ru.job4j.console_war.ui.view;

import ru.job4j.console_war.ui.controller.ViewController;
import ru.job4j.console_war.ui.menu.MenuItem;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static ru.job4j.console_war.RunApp.validator;

public class MainViewImpl implements MainView {
    private ViewController controller;

    private Map<Integer, MenuItem> menuItems = new LinkedHashMap<>();

    public MainViewImpl() {

    }

    public MainViewImpl(ViewController controller) {
        this();
        setController(controller);
    }

    @Override
    public void setController(ViewController controller) {
        this.controller = controller;
    }

    @Override
    public void showGreetings() {
        System.out.println("Добро пожаловать в игру!");
    }

    public void putMenu(int number, MenuItem menuItem) {
        menuItems.put(number, menuItem);
    }

    @Override
    public void showConsoleMenu() {
        for (Map.Entry<Integer, MenuItem> entry : menuItems.entrySet()) {
            System.out.printf("%s. %s\n", entry.getKey(), entry.getValue().intro());
        }

        int answer = 1;
        while (answer != 0) {
            int choice = validator.getIntFromList("Выберите пункт меню: ", this.menuItems.keySet());
            answer = menuItems.get(choice).execute(controller);
        }

    }

    // создать светлый отряд
    public void createLightSquad() {
        int choice = validator.getIntFromList("Выберите отряд 1 - Люди, 2 - Эльфы: ", Arrays.asList(1, 2));
        controller.createLightSquad(choice);
    }

    // создать темный отряд
    public void createDarkSquad() {
        int choice = validator.getIntFromList("Выберите отряд 1 - Орки, 2 - Нежить: ", Arrays.asList(1, 2));
        controller.createDarkSquad(choice);
    }

    @Override
    public int startGame() {
        return controller.startGame();
    }

    @Override
    public void randomGame() {
        controller.randomGame();
    }
}
