package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class MagicStaff extends Weapon {

    public MagicStaff(double damage) {
        super("MagicStaff", damage);
    }

    @Override
    public String printAction() {
        return "атаковал магией " + "(" + this.name + "):";
    }
}
