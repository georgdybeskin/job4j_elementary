package ru.job4j.console_war.model.unit.undead;

import ru.job4j.console_war.model.unit.Warrior;
import ru.job4j.console_war.model.weapon.Spear;

public class UndeadZombie extends Warrior {

    public UndeadZombie() {
        // Установим начальное оружие и силу урона
        setPrimary(new Spear(18)); // атаковать копьём : урон 18 ед.
    }
}
