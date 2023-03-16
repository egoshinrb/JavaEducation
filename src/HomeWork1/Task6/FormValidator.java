package HomeWork1.Task6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
написать класс FormValidator со статическими методами проверки имени, даты рождения, пола и роста
 */
public class FormValidator {

    public static void main(String[] args) {
        try {
            checkName("As");
//            checkName("A1s");
//            checkName("As-");
//            checkName("A");
//            checkName("s");
//            checkName("");

            checkBirthdate("28.02.2022");
//            checkBirthdate("29.02.2022");
//            checkBirthdate("19.03.2023");
//            checkBirthdate("00.01.1900");
//            checkBirthdate("11..03.23");

            checkGender("Male");
            checkGender("Female");
//            checkGender("Ma");


            checkHeight("1.02");
//            checkHeight("abc");
//            checkHeight("1..02");

            String str = "Hello";
            char[] arr = str.toCharArray();

            System.out.println(arr[1]);

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    private FormValidator() {
    }

    //    длина имени должна быть от 2 до 20 символов, первая буква заглавная.
    public static void checkName(String str) throws IllegalArgumentException {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("Строка Name не должна быть пустой.");
        }

        if (!str.matches("[A-Z][a-z]{1,19}")) {
            throw new IllegalArgumentException("Строка Name не прошла проверку.");
        }
    }

    //    дата рождения должна быть не раньше 01.01.1900 и не позже текущей даты
    public static void checkBirthdate(String str) throws ParseException, IllegalArgumentException {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("Строка Birthdate не должна быть пустой.");
        }

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);

        Date firstDate = formatter.parse("01.01.1900");
        Date nowDate = new Date();
        Date currDate = formatter.parse(str);

        if (currDate.after(nowDate) || currDate.before(firstDate)) {
            throw new IllegalArgumentException("Дата не может быть позже текущей даты или ранее 01.01.1900");
        }
    }


    //    пол должен корректно матчится в enum Gender, хранящий Male и Female значения
    public static void checkGender(String str) throws IllegalArgumentException {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("Строка Gender не должна быть пустой.");
        }

        Gender.valueOf(str);
    }

    //    рост должен быть положительным числом и корректно конвертироваться в double
    public static void checkHeight(String str) throws IllegalArgumentException {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("Строка Height не должна быть пустой.");
        }

        if (Double.parseDouble(str) < 0) {
            throw new IllegalArgumentException("Рост должен быть положительным числом.");
        }
    }

    enum Gender {
        Male,
        Female
    }
}
