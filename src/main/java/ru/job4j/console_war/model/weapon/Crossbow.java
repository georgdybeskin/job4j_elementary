package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Crossbow extends Weapon {

    public Crossbow(double damage) {
        super("Crossbow", damage);
    }

    @Override
    public String printAction() {
        return "выстрелил из арбалета " + "(" + this.name + "):";
    }
}
