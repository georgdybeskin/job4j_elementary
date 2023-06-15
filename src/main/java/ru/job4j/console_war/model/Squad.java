package ru.job4j.console_war.model;

import ru.job4j.console_war.Game;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.console_war.RunApp.LOGGER;

/**
 * Класс описывающий структуру отряда как боевой единицы.
 * хранит в себе разбиение на группы (привилегированная, обычная, мертвые)
 */
public class Squad {
    private Game game;
    private String squadName;

    private List<Unit> privilegedSquad = new ArrayList<>();
    private List<Unit> normalSquad = new ArrayList<>();
    private List<Unit> deadList = new ArrayList<>();

    public Squad(Game game) {
        this.game = game;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public List<Unit> getPrivilegedSquad() {
        return privilegedSquad;
    }

    public List<Unit> getNormalSquad() {
        return normalSquad;
    }

    public List<Unit> getDeadList() {
        return deadList;
    }

    /**
     * Добавить/перенести юнита в привилегированную группу
     *
     * @param unit юнит
     */
    public void adToPrivileged(Unit unit) {
        unit.setGame(game);
        unit.setSquad(this);
        normalSquad.remove(unit);
        unit.setDamageModValue(1.5);

        if (!privilegedSquad.contains(unit)) {
            privilegedSquad.add(unit);
        }
    }

    /**
     * Добавить/перенести юнита в обычную группу
     *
     * @param unit юнит
     */
    public void adToNormal(Unit unit) {
        unit.setGame(game);
        unit.setSquad(this);
        privilegedSquad.remove(unit);
        unit.setDamageModValue(1.0);

        if (!normalSquad.contains(unit)) {
            normalSquad.add(unit);
        }
    }

    /**
     * Перенести юнита в список мертвых
     *
     * @param unit юнит
     */
    public void adToDeadList(Unit unit) {
        privilegedSquad.remove(unit);
        normalSquad.remove(unit);

        deadList.add(unit);
    }

    /**
     * Произвести очередной ход.
     * В случае поражения отряда вернуть "true"
     */
    public boolean makeTurn() {
        LOGGER.info("Ход {}, отряд {}\n", Game.turn++, squadName);

        if (privilegedSquad.size() > 0) {
            privilegedSquad.get((int) (Math.random() * privilegedSquad.size()))
                    .doAction();
        } else if (normalSquad.size() > 0) {
            normalSquad.get((int) (Math.random() * normalSquad.size()))
                    .doAction();
        } else {
            LOGGER.info("Отряд {} повержен!\n\n", squadName);
            Game.turn--;
            return true;
        }
        return false;
    }

    /**
     * Получить рандомного юнита из отряда
     *
     * @return random unit
     */
    public Unit getRandomUnit() {
        ArrayList<Unit> units = new ArrayList<>();
        units.addAll(privilegedSquad);
        units.addAll(normalSquad);
        return units.get((int) (Math.random() * units.size()));
    }

    /**
     * Получить рандомного юнита за исключением текущего.
     * Однако, если кроме текущего никого не осталось, вернёт себя же.
     *
     * @param unit юнит для исключения из выборки
     * @return random unit
     */
    public Unit getRandomUnitExcept(Unit unit) {
        ArrayList<Unit> units = new ArrayList<>();
        units.addAll(privilegedSquad);
        units.addAll(normalSquad);
        units.remove(unit);
        if (units.size() > 0) {
            return units.get((int) (Math.random() * units.size()));
        }
        return unit;
    }

    /**
     * Получить рандомного юнита из привилегированного отряда.
     * Если он пуст, получить обычного.
     *
     * @return random privileged unit
     */
    public Unit getRandomPrivilegedUnit() {
        Unit enemyUnit = getRandomUnit();
        if (privilegedSquad.size() != 0) {
            enemyUnit = privilegedSquad.get((int) (Math.random() * privilegedSquad.size()));
        }
        return enemyUnit;
    }

    /**
     * Проверить наличие живых юнитов в отряде
     *
     * @return "true" если не осталось живых юнитов в отряде или "false" если кто-то ещё жив
     */
    public boolean isDefeated() {
        return (privilegedSquad.size() == 0 && normalSquad.size() == 0);
    }
}
