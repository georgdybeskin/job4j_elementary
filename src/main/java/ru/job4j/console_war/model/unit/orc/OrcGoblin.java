package ru.job4j.console_war.model.unit.orc;

import ru.job4j.console_war.model.unit.Warrior;
import ru.job4j.console_war.model.weapon.Club;

public class OrcGoblin extends Warrior {

    public OrcGoblin() {
        // Установим начальное оружие и силу урона
        setPrimary(new Club(20)); // атаковать дубиной : урон 20 ед.
    }
}
