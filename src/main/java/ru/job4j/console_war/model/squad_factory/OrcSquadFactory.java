package ru.job4j.console_war.model.squad_factory;

import ru.job4j.console_war.Game;
import ru.job4j.console_war.model.Squad;
import ru.job4j.console_war.model.unit.orc.OrcArcher;
import ru.job4j.console_war.model.unit.orc.OrcGoblin;
import ru.job4j.console_war.model.unit.orc.OrcShaman;

public class OrcSquadFactory implements SquadFactory {

    @Override
    public Squad createSquad(Game game, int mageCount, int archerCount, int warriorCount) {
        Squad squad = new Squad(game);
        squad.setSquadName("OrcSquad");

        for (int i = 1; i < mageCount + 1; i++) {
            OrcShaman orcShaman = new OrcShaman();
            orcShaman.setName("OrcShaman_" + i);
            squad.adToNormal(orcShaman);
        }
        for (int i = 1; i < archerCount + 1; i++) {
            OrcArcher orcArcher = new OrcArcher();
            orcArcher.setName("OrcArcher_" + i);
            squad.adToNormal(orcArcher);
        }
        for (int i = 1; i < warriorCount + 1; i++) {
            OrcGoblin orcGoblin = new OrcGoblin();
            orcGoblin.setName("OrcGoblin_" + i);
            squad.adToNormal(orcGoblin);
        }

        return squad;
    }
}
