package ru.job4j.console_war.service;

import ru.job4j.console_war.Game;
import ru.job4j.console_war.model.Squad;
import ru.job4j.console_war.model.squad_factory.*;

public class GameServiceImpl implements GameService {
    private Game game;

    public GameServiceImpl() {

    }

    public GameServiceImpl(Game game) {
        this();
        this.game = game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public Squad createSquad(SquadFactory squadFactory) {
        return game.createSquad(squadFactory);
    }

    @Override
    public void createRandomLightSquad() {
        game.createRandomLightSquad();
    }

    @Override
    public void createRandomDarkSquad() {
        game.createRandomDarkSquad();
    }

    @Override
    public void printWinner() {
        game.printWinner();
    }

    @Override
    public Squad getDarkSquad() {
        return game.getDarkSquad();
    }

    @Override
    public Squad getLightSquad() {
        return game.getLightSquad();
    }

    @Override
    public void createLightSquad(int number) {
        switch (number) {
            case 1:
                game.setLightSquad(createSquad(new HumanSquadFactory()));
                break;
            case 2:
                game.setLightSquad(createSquad(new ElfSquadFactory()));
                break;
        }
    }

    @Override
    public void createDarkSquad(int number) {
        switch (number) {
            case 1:
                game.setDarkSquad(createSquad(new OrcSquadFactory()));
                break;
            case 2:
                game.setDarkSquad(createSquad(new UndeadSquadFactory()));
                break;
        }
    }

    @Override
    public int startGame() {
        int answer = 0;

        if (getLightSquad() == null) {
            System.out.println("Светлый отряд пуст. Создайте светлый отряд");
            answer = 1;
        } else if (getDarkSquad() == null) {
            System.out.println("Темный отряд пуст. Создайте темный отряд");
            answer = 1;
        } else {
            game.runGame();
        }
        return answer;
    }

    public void randomGame() {
        createRandomLightSquad();
        createRandomDarkSquad();
        startGame();
    }
}
