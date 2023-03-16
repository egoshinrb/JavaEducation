package HomeWork1.Task5;

import java.util.Scanner;

/*
Найти и исправить ошибки в следующем коде
 */
public class Main {
    public static void main(String[] args) {
        try {
            inputN();
            System.out.println("Успешный ввод!");
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    private static void inputN() throws IllegalArgumentException {
        System.out.println("Введите число n, 0 < n < 100");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 100 || n <= 0) {
            throw new IllegalArgumentException("Неверный ввод");
        }
    }
}
