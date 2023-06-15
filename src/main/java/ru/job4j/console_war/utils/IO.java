package ru.job4j.console_war.utils;

public interface IO {

    /**
     * Читать данные из входящего потока
     */
    String read();

    /**
     * Вывести значение в исходящий поток
     *
     * @param value value to string
     */
    void println(Object value);
}
