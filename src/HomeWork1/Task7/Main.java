package HomeWork1.Task7;

import java.util.Scanner;

/*
На вход подается число n и массив целых чисел длины n.
Вывести два максимальных числа в этой последовательности.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            if (count < 2) {
                throw new IllegalArgumentException("Число должно быть положительным и более 2");
            }

            int[] arr = new int[count];
            while (count-- > 0) {
                arr[count] = scanner.nextInt();
            }

            printTwoMaxNumber(arr);
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void printTwoMaxNumber(int[] arr) {
        int firstMax = arr[0];
        int secondMax = arr[1];

        if (secondMax > firstMax) {
            secondMax += firstMax;
            firstMax = secondMax - firstMax;
            secondMax = secondMax - firstMax;
        }

        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        System.out.println("Два максимальных числа: " + firstMax + " " + secondMax);
    }
}
