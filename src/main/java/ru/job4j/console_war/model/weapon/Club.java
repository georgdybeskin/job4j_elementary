package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Club extends Weapon {

    public Club(double damage) {
        super("Club", damage);
    }

    @Override
    public String printAction() {
        return "ударил дубиной " + "(" + this.name + "):";
    }
}
