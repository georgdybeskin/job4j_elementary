package ru.job4j.console_war.model.unit.elf;

import ru.job4j.console_war.model.Skill;
import ru.job4j.console_war.model.Unit;
import ru.job4j.console_war.model.skill.PowerUp;
import ru.job4j.console_war.model.unit.Mage;
import ru.job4j.console_war.model.weapon.MagicStaff;

import static ru.job4j.console_war.RunApp.LOGGER;

public class ElfMage extends Mage {

    public ElfMage() {
        // Установим начальное оружие и силу урона
        setPrimary(new MagicStaff(10)); // атаковать магией : урон 10 ед.
        setSecondary(new PowerUp(0, 1)); // наложить улучшение на союзника
    }

    @Override
    public void action2() {
        // наложить улучшение на персонажа своего отряда
        Unit ally = game.getAlly(this);
        ally.addBuff((Skill) getSecondary());
        ally.checkAndApplyBuff();
        LOGGER.info("{} {} ({})\n\n", this.getName(), getSecondary().printAction(), ally.getName());
        this.decreaseBuffDurationOrDelete();
        this.getSquad().adToNormal(this);
    }
}
