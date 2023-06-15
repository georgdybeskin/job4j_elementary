package ru.job4j.console_war.model.unit.human;

import ru.job4j.console_war.model.unit.Warrior;
import ru.job4j.console_war.model.weapon.Sword;

public class HumanWarrior extends Warrior {

    public HumanWarrior() {
        // Установим начальное оружие и силу урона
        setPrimary(new Sword(18)); // атаковать мечом : урон 18 ед.
    }
}
