package ru.job4j.console_war.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Класс для чтения входящего потока и вывода в консоль
 * Основан на классе scanner
 */
public class ConsoleIO implements IO {
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleIO.class);
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleIO(final Scanner scanner, final PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    /**
     * Считать следующую входящую строку
     *
     * @return строка
     */
    @Override
    public String read() {
        return this.scanner.next();
    }

    /**
     * Вывести значение в исходящий поток
     *
     * @param value значение в строку
     */
    @Override
    public void println(Object value) {
        this.out.println(value);
    }

}
