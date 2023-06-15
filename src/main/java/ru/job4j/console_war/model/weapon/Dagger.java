package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Dagger extends Weapon {

    public Dagger(double damage) {
        super("Dagger", damage);
    }

    @Override
    public String printAction() {
        return "ударил кинжалом " + "(" + this.name + "):";
    }
}
