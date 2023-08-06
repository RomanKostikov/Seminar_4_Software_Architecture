package ClientApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Абстрактный класс валидации вводимых данных
 */
public abstract class EnterData {
    /**
     * Метод ввода и валидации целого числа в диапазоне
     *
     * @param minVariant минимальное число
     * @param maxVariant максимальное число
     * @return введенное целое число
     * @throws RuntimeException
     */
    protected int inputInt(int minVariant, int maxVariant) throws RuntimeException {
        int num = 0;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextInt();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("This is not number.");
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (num < minVariant || num > maxVariant) {
            throw new RuntimeException("You entered an invalid value.");
        }
        return num;
    }

    /**
     * Метод ввода и валидации целого числа в диапазоне
     *
     * @param minVariant минимальное число
     * @param maxVariant максимальное число
     * @return введенное целое число
     * @throws RuntimeException
     */
    protected long inputLong(long minVariant, long maxVariant) throws RuntimeException {
        long num = 0;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextLong();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("This is not number.");
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (num < minVariant || num > maxVariant) {
            throw new RuntimeException("You entered an invalid value.");
        }
        return num;
    }

    /**
     * Метод ввода строки и ее валидация на пустую строку
     *
     * @return строку
     */
    protected String inputString() throws RuntimeException {
        Scanner in = new Scanner(System.in);
        String str;
        try {
            str = in.next();
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (str.isEmpty()) {
            throw new RuntimeException("You must something enter");
        }
        return str;
    }

    /**
     * Meтод ввода даты и ее валидация
     *
     * @return дата
     * @throws RuntimeException
     */
    protected Date inputDate() throws RuntimeException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Scanner in = new Scanner(System.in);
        String str;
        Date date;
        try {
            str = in.nextLine();
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (str.isEmpty()) {
            throw new RuntimeException("You must something enter");
        }
        try {
            date = ft.parse(str);
        } catch (ParseException ex) {
            throw new RuntimeException("You must enter date");
        }
        return date;
    }
}
