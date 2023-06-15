package ru.job4j.console_war.model;

public interface UnitAction {

    /**
     * Выполнить действие
     */
    void doAction();

    /**
     * Выполнить первичное действие
     */
    void action1();

    /**
     * Выполнить вторичное действие
     */
    void action2();
}
