package ru.job4j.console_war.model.skill;

import ru.job4j.console_war.model.Skill;
import ru.job4j.console_war.model.Unit;

/**
 * Скилл улучшение.
 * Наложение улучшения на персонажа своего отряда.
 */
public class PowerUp extends Skill {

    public PowerUp(double damage, int duration) {
        super("PowerUp", damage, duration);
    }

    @Override
    public String printAction() {
        return "наложил на союзника улучшение " + "(" + this.name + "):";
    }

    @Override
    public void doAction(Unit unit) {
        if (!this.isUsed){
            unit.getSquad().adToPrivileged(unit);
            setUsed(true);
        }
    }
}
