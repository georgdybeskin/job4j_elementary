package ru.job4j.console_war.model.skill;

import ru.job4j.console_war.model.Skill;
import ru.job4j.console_war.model.Unit;

/**
 * Скилл проклятие.
 * Наложение проклятия (снятие улучшения с персонажа противника для следующего хода).
 */
public class Curse extends Skill {

    public Curse(double damage, int duration) {
        super("Curse", damage, duration);
    }

    @Override
    public String printAction() {
        return "наложил на противника проклятие " + "(" + this.name + "):";
    }

    @Override
    public void doAction(Unit unit) {
        if (!this.isUsed) {
            unit.getSquad().adToNormal(unit);
            setUsed(true);
        }
    }
}
