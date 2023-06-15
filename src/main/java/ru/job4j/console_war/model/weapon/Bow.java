package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Bow extends Weapon {

    public Bow(double damage) {
        super("Bow", damage);
    }

    @Override
    public String printAction() {
        return "выстрелил из лука " + "(" + this.name + "):";
    }
}
