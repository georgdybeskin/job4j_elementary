package ru.job4j.console_war.ui.controller;

import ru.job4j.console_war.service.GameService;

public class ViewControllerImpl implements ViewController {
    private GameService service;

    public ViewControllerImpl() {

    }

    public ViewControllerImpl(GameService service) {
        this();
        this.service = service;
    }

    @Override
    public void setService(GameService service) {
        this.service = service;
    }

    @Override
    public void createLightSquad(int number) {
        service.createLightSquad(number);
    }

    @Override
    public void createDarkSquad(int number) {
        service.createDarkSquad(number);
    }

    @Override
    public int startGame() {
       return service.startGame();
    }

    @Override
    public void randomGame() {
        service.randomGame();
    }

    @Override
    public void exit() {
        System.exit(0);
    }

}
