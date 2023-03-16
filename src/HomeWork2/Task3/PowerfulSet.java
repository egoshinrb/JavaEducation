package HomeWork2.Task3;

import java.util.*;

/*
Реализовать класс PowerfulSet, в котором должны быть следующие методы:
a. public <T> Set<T> intersection(Set<T> set1, Set<T> set2) — возвращает пересечение двух наборов.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}

b. public <T> Set<T> union(Set<T> set1, Set<T> set2) — возвращает объединение двух наборов.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}

c. public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) —
возвращает элементы первого набора без тех, которые находятся также и во втором наборе.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
 */
public class PowerfulSet {
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>(Arrays.asList(3, 4, 5, 6));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(5, 6, 7, 8));

        try {
            System.out.println("Пересечение: " + intersection(set1, set2));
            System.out.println("Объединение: " + union(set1, set2));
            System.out.println("Разность: " + relativeComplement(set1, set2));
            System.out.println("Исходный сет1" + set1);
            System.out.println("Исходный сет2" + set2);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            throw new IllegalArgumentException("Множества не должны быть null");
        }

        Set<T> newSet = new HashSet<>(set1);
        newSet.retainAll(set2);
        return newSet;
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            throw new IllegalArgumentException("Множества не должны быть null");
        }

        Set<T> newSet = new HashSet<>(set1);
        newSet.addAll(set2);
        return newSet;
    }

    public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) throws IllegalArgumentException {
        if (set1 == null || set2 == null) {
            throw new IllegalArgumentException("Множества не должны быть null");
        }

        Set<T> newSet = new HashSet<>(set1);
        newSet.removeAll(set2);
        return newSet;
    }
}
