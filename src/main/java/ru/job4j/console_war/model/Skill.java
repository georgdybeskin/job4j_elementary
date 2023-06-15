package ru.job4j.console_war.model;

/**
 * Класс описывающий навык/скилл в игре
 */
public abstract class Skill implements WeaponAction, Cloneable{
    protected String name;
    protected double damage;
    protected int duration;
    protected boolean isUsed;

    public Skill(String name, double damage, int duration) {
        this.name = name;
        this.damage = damage;
        this.duration = duration;
    }

    public double getDamage() {
        return damage;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", duration=" + duration +
                ", isUsed=" + isUsed +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
