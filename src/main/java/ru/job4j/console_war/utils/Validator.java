package ru.job4j.console_war.utils;

import java.util.Collection;

/**
 * Класс для валидации вводимых пользователем данных в консоль.
 */
public class Validator implements AutoCloseable {
    private final IO io;

    public Validator(final IO io) {
        this.io = io;
    }

    /**
     * Получить число из входящего потока.
     * Повторять до тех пор, когда ввод будет корректным
     *
     * @param message - сообщение
     * @return double
     */
    public double getDouble(String message) {
        boolean invalid;
        do {
            try {
                System.out.println(message);
                return Double.parseDouble(this.io.read());
            } catch (NumberFormatException n) {
                invalid = true;
//                LOGGER.error("Convert number error", n);
                System.out.println("Ошибка чтения, введите корректное число.");
            }
        } while (invalid);
        throw new NumberFormatException();
    }

    /**
     * Сравнить ввод с предустановленным ответом
     *
     * @param message - сообщение
     * @param answer  - предустановленное сообщение для сравнения
     * @return boolean
     */
    public boolean compare(final String message, final String answer) {
        System.out.println(message);
        return answer.equals(io.read());
    }

    @Override
    public void close() throws Exception {
    }

    /**
     * Получить строку из ввода
     *
     * @param message - сообщение
     * @return string
     */
    public String getString(String message) {
        System.out.println(message);
        return this.io.read();
    }

    /**
     * Получить число из ввода
     * Повторять до тех пор, пока ввод не будет соответствовать одному из элементов коллекции "keys"
     *
     * @param message - сообщение
     * @param keys    - коллекция элементов для сравнения
     * @return Integer
     */
    public Integer getIntFromList(final String message, final Collection<Integer> keys) {
        boolean invalid;
        do {
            try {
                System.out.println(message);
                final int result = Integer.parseInt(this.io.read());
                if (keys.contains(result)) {
                    return result;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException n) {
                invalid = true;
//                LOGGER.error("Convert number error or key not present", n);
                System.out.println("Такого номера нет в наборе, попробуйте снова.");
            }
        } while (invalid);
        throw new NumberFormatException();
    }

    /**
     * Получить число из ввода
     * Повторять, пока ввод не будет корректным
     *
     * @param message - сообщение
     * @return int
     */
    public int getInt(String message) {
        boolean invalid;
        do {
            try {
                System.out.println(message);
                return Integer.parseInt(this.io.read());
            } catch (NumberFormatException n) {
                invalid = true;
//                LOGGER.error("Convert number error", n);
                System.out.println("Ошибка чтения, введите корректное число.");
            }
        } while (invalid);
        throw new NumberFormatException();
    }
}
