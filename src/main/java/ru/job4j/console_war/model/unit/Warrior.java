package ru.job4j.console_war.model.unit;

import ru.job4j.console_war.model.Unit;

/**
 * Класc юнита - воин
 */
public class Warrior extends Unit {

    @Override
    public void action2() {
        action1();
    }
}
