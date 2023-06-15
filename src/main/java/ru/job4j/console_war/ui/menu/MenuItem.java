package ru.job4j.console_war.ui.menu;

import ru.job4j.console_war.ui.controller.ViewController;

public interface MenuItem {

    /**
     * Выполнить действие меню
     * @param controller
     * @return число 1 (продолжить ожидание ввода) или 0 (завершить ввод)
     */
    int execute(final ViewController controller);

    /**
     * Описание действия меню
     * @return строка с описанием
     */
    String intro();
}
