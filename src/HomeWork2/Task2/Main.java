package HomeWork2.Task2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
С консоли на вход подается две строки s и t. Необходимо вывести true,
если одна строка является валидной анаграммой другой строки и false иначе.
Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы,
обычно с использованием всех исходных букв ровно один раз.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str1 = scanner.next();
            String str2 = scanner.next();

            try {
                System.out.println(isAnagram(str1, str2));
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    public static boolean isAnagram(String str1, String str2) throws IllegalArgumentException {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Строки не должны быть пустыми");
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map = new TreeMap<>();
        for (Character i : str1.toCharArray()) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        if (map.size() > str2.length()) {
            return false;
        }

        int count;
        for (Character i : str2.toCharArray()) {
            if (map.containsKey(i)) {
                count = map.get(i);
                if (count > 1) {
                    map.replace(i, --count);
                } else {
                    map.remove(i);
                }
            } else {
                return false;
            }
        }

        return true;
    }


}
