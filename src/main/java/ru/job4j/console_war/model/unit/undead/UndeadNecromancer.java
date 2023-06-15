package ru.job4j.console_war.model.unit.undead;

import ru.job4j.console_war.model.Skill;
import ru.job4j.console_war.model.Unit;
import ru.job4j.console_war.model.skill.Ailment;
import ru.job4j.console_war.model.unit.Mage;
import ru.job4j.console_war.model.weapon.MagicStaff;

import static ru.job4j.console_war.RunApp.LOGGER;

public class UndeadNecromancer extends Mage {

    public UndeadNecromancer() {
        // Установим начальное оружие и силу урона
        setPrimary(new MagicStaff(5)); // атаковать магией : урон 5 ед.
        setSecondary(new Ailment(0, 1)); // наслать недуг на противника
    }

    @Override
    public void action2() {
        // наслать недуг на противника
        Unit enemy = game.getEnemy(this);
        enemy.addBuff((Skill) getSecondary());
        enemy.checkAndApplyBuff();
        LOGGER.info("{} {} ({})\n\n", this.getName(), getSecondary().printAction(), enemy.getName());
        this.getSquad().adToNormal(this);
    }
}
