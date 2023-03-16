package HomeWork2.Task5;

import java.util.*;
import java.util.stream.Collectors;

/*
Реализовать метод, который принимает массив words и целое положительное число k.
Необходимо вернуть k наиболее часто встречающихся слов
Результирующий массив должен быть отсортирован по убыванию частоты встречаемого слова.
В случае одинакового количества частоты для слов, то отсортировать
и выводить их по убыванию в лексикографическом порядке.
 */
public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "day"};
        String[] words1 = new String[]{"a", "a", "b", "b", "c", null};
        System.out.println(Arrays.toString(getPopularWords(words, 4)));
        System.out.println(Arrays.toString(getPopularWords(words1, 4)));
    }

    public static String[] getPopularWords(String[] words, int count) {
        if (words == null) {
            return null;
        }

        Map<String, Integer> map = new TreeMap<>();
        for (var i : words) {
            if (i == null) {
                continue;
            }
            Integer temp = map.get(i);
            map.put(i, temp == null ? 1 : ++temp);
        }
//      1 способ: переводим мапу в лист с типом Entry, сортируем как нам надо и копируем ключи в массив
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((x1, x2) -> x2.getValue() - x1.getValue() != 0 ? x2.getValue() - x1.getValue() : (x2.getKey().compareTo(x1.getKey())));

        String[] res = new String[Math.min(map.size(), count)];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i).getKey();
        }


/*        2 способ - без промежуточного листа: кидаем мапу в стрим, сортируем его, берем первые N значений из стрима и конвертируем его снова в мапу,
        указывая, что теперь это LinkedHashMap. Затем ключи мапу пишем в массив Object, который переводим в массив String
        map = map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue() != 0 ? e2.getValue() - e1.getValue() : e2.getKey().compareTo(e1.getKey()))
                .limit(count).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> { throw new IllegalArgumentException(); },  LinkedHashMap::new));

        String [] res = new String[map.size()];
        int i = 0;
        for (var j : map.keySet().toArray()) {
            res[i++] = (String) j;
        } */

        return res;
    }
}
