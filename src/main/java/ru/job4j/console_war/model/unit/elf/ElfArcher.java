package ru.job4j.console_war.model.unit.elf;

import ru.job4j.console_war.model.unit.Archer;
import ru.job4j.console_war.model.weapon.Bow;
import ru.job4j.console_war.model.weapon.Fist;

public class ElfArcher extends Archer {

    public ElfArcher() {
        // Установим начальное оружие и силу урона
        setPrimary(new Bow(7)); // стрелять из лука : урон 7 ед.
        setSecondary(new Fist(3)); // атаковать противника : урон 3 ед.
    }
}
