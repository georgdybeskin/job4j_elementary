package ru.job4j.console_war.model;

public interface WeaponAction {

    /**
     * Вывести описание действия для оружия/скилла
     * @return описание действия
     */
    String printAction();

    /**
     * Выполнить действие оружия/скилла на юните
     * @param unit for action
     */
    void doAction(Unit unit);

    double getDamage();
}
