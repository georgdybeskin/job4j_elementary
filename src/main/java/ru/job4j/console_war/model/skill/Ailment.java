package ru.job4j.console_war.model.skill;

import ru.job4j.console_war.model.Skill;
import ru.job4j.console_war.model.Unit;

/**
 * Скилл недуг.
 * Наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход).
 */
public class Ailment extends Skill {

    public Ailment(double damage, int duration) {
        super("Ailment", damage, duration);
    }

    @Override
    public String printAction() {
        return "наложил на противника недуг " + "(" + this.name + "):";
    }

    @Override
    public void doAction(Unit unit) {
        if (!this.isUsed) {
            unit.setDamageModValue(0.5);
            setUsed(true);
        }
    }
}
