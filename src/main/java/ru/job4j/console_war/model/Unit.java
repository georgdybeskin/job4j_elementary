package ru.job4j.console_war.model;

import ru.job4j.console_war.Game;
import ru.job4j.console_war.model.weapon.Fist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static ru.job4j.console_war.RunApp.LOGGER;

/**
 * Класс описывающий юнита - общий скелет для всех юнитов.
 */
public abstract class Unit implements UnitAction {
    protected Game game;
    protected Squad squad;

    protected String name;
    protected WeaponAction primary;
    protected WeaponAction secondary;
    protected double health = 100.0;
    protected double damageModValue = 1.0;

    protected Set<Skill> buffList = new HashSet<>();

    public Unit() {
        this.primary = new Fist(1);
        this.secondary = new Fist(1);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponAction getPrimary() {
        return primary;
    }

    public void setPrimary(WeaponAction weapon) {
        this.primary = weapon;
    }

    public WeaponAction getSecondary() {
        return secondary;
    }

    public void setSecondary(WeaponAction secondaryWep) {
        this.secondary = secondaryWep;
    }

    public double getDamageModValue() {
        return damageModValue;
    }

    public void setDamageModValue(double damageModValue) {
        this.damageModValue = damageModValue;
    }

    /**
     * Подсчитать урон с учётом бафов и модификатора урона
     *
     * @return result damage
     */
    public Double countPrimaryDamage() {
        checkAndApplyBuff();
        return primary.getDamage() * getDamageModValue();
    }

    public Double countSecondaryDamage() {
        checkAndApplyBuff();
        return secondary.getDamage() * getDamageModValue();
    }

    /**
     * Добавить баф/дебав в список бафов действующих на унита
     *
     * @param buff баф действующий на юнита
     */
    public void addBuff(Skill buff) {
        try {
            // передаём не ссылку а копию объекта ибо в нём будет менятся duration
            // что позволит нам использовать скилл снова в первоначальном виде
            Skill copy = (Skill) buff.clone();
            this.buffList.add(copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Пройтись по списку бафов(скиллов) и активировать
     */
    public void checkAndApplyBuff() {
        Iterator iterator = buffList.iterator();
        while (iterator.hasNext()) {
            Skill skill = (Skill) iterator.next();
            if (!skill.isUsed) {
                skill.doAction(this);
            } else if (skill.duration <= 0) {
                iterator.remove();
            }
        }
    }

    /**
     * Пройтись по списку бафов, уменьшить их длительность и очистить истекшие
     */
    public void decreaseBuffDurationOrDelete() {
        Iterator iterator = buffList.iterator();
        while (iterator.hasNext()) {
            Skill buff = (Skill) iterator.next();
            if (--buff.duration <= 0) {
                iterator.remove();
            }
        }
    }

    /**
     * Фиксация урона юниту
     *
     * @param damage количество урона
     * @return 0 если юнит ещё жив или 1 если юнит мёртв
     */
    public int hit(double damage) {
        this.health -= damage;
        LOGGER.info("{} получил урон: -{} HP\n", this.getName(), damage);
        if (health > 0) {
            LOGGER.info("Осталось: {} HP\n\n", health);
        } else {
            LOGGER.info("Убит\n\n");
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return " "
                + name
                + " | " + health + " HP\n";
    }

    @Override
    public void doAction() {
        int actions = 2;

        int random = (int) (Math.random() * actions) + 1;
        switch (random) {
            case 1:
                action1();
                break;
            case 2:
                action2();
                break;
            default:
                action1();
        }
    }

    @Override
    public void action1() {
        Unit enemy = game.getEnemy(this); // получить противника
        double damage = this.countPrimaryDamage(); // вычислить собственный урон
        LOGGER.info("{} {} {} ед.\n", this.getName(), getPrimary().printAction(), damage);
        game.hit(enemy, damage); // нанести противнику урон
        this.decreaseBuffDurationOrDelete(); // отсчитать -1 ход баффам на себе
        this.getSquad().adToNormal(this); // вернуться в обычную группу и вернуть damageModValue в 1.0 (первоначальное)
    }

    @Override
    public void action2() {
        Unit enemy = game.getEnemy(this);
        double damage = this.countSecondaryDamage();
        LOGGER.info("{} {} {} ед.\n", this.getName(), getSecondary().printAction(), damage);
        game.hit(enemy, damage);
        this.decreaseBuffDurationOrDelete();
        this.getSquad().adToNormal(this);
    }
}
