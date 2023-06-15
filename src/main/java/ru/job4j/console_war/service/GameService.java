package ru.job4j.console_war.service;

import ru.job4j.console_war.model.Squad;
import ru.job4j.console_war.model.squad_factory.SquadFactory;

public interface GameService {
    /**
     * Создать отряд
     * @param squadFactory фабрики соответствующего класса юнитов
     * @return squad
     */
    Squad createSquad(SquadFactory squadFactory);

    /**
     * Создать отряд светлых (эльфы или люди)
     * @return squad
     */
    void createRandomLightSquad();

    /**
     * Создать отряд темных (орки или нежить)
     * @return squad
     */
    void createRandomDarkSquad();

    /**
     * Вывести результат победы
     */
    void printWinner();

    /**
     * Получить темный отряд
     * @return squad
     */
    Squad getDarkSquad();

    /**
     * Получить светлый отряд
     * @return squad
     */
    Squad getLightSquad();

    /**
     * Создать светлый отряд
     * @param number номер для выбора из доступных
     */
    void createLightSquad(int number);

    /**
     * Создать тёмный отряд
     * @param number номер для выбора из доступных
     */
    void createDarkSquad(int number);

    /**
     * Начать игру
     */
    int startGame();

    /**
     * Начать случайную игру
     */
    void randomGame();
}
