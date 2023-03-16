package HomeWork2.Task1;

import java.util.*;

/*
Реализовать метод, который на вход принимает ArrayList<T>,
а возвращает набор уникальных элементов этого массива.
Решить используя коллекции.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Number> list1 = new ArrayList<>(Arrays.asList(6, 6, 7, 8, null));
        System.out.println(getUnique(list1));

    }

    public static <T> TreeSet<T> getUnique(ArrayList<T> array) {
        if (Objects.isNull(array)) {
            return null;
        }

        TreeSet<T> set = new TreeSet<>();
        for (var i : array) {
            if (!Objects.isNull(i)) {
                set.add(i);
            }
        }
        return set;
    }


}
