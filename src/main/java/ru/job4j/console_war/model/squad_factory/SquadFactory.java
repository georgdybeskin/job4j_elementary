package ru.job4j.console_war.model.squad_factory;

import ru.job4j.console_war.Game;
import ru.job4j.console_war.model.Squad;

public interface SquadFactory {

    Squad createSquad(Game game, int mageCount, int archerCount, int warriorCount);
}
