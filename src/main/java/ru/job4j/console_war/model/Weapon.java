package ru.job4j.console_war.model;

/**
 * Класс описывающий оружие в игре
 */
public abstract class Weapon implements WeaponAction {
    protected String name;
    protected double damage;

    public Weapon(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }

    @Override
    public void doAction(Unit unit) {
        // для оружия не используется
    }
}
