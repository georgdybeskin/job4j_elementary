package ru.job4j.console_war.model.unit.undead;

import ru.job4j.console_war.model.unit.Archer;
import ru.job4j.console_war.model.weapon.Bow;
import ru.job4j.console_war.model.weapon.Fist;

public class UndeadHunter extends Archer {

    public UndeadHunter() {
        // Установим начальное оружие и силу урона
        setPrimary(new Bow(4)); // стрелять из лука : урон 4 ед.
        setSecondary(new Fist(2)); // атаковать противника : урон 2 ед.
    }
}
