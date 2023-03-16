package HomeWork3.Task5;

import java.util.Stack;

/*
Дана строка, состоящая из символов “(“ и “)”
Необходимо написать метод, принимающий эту строку и выводящий результат,
является ли она правильной скобочной последовательностью или нет.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Test 1: " + isCorrectBrackets("((()))"));
            System.out.println("Test 2: " + isCorrectBrackets("()()()((((()()()()))))"));
            System.out.println("Test 3: " + isCorrectBrackets(")()("));
            System.out.println("Test 4: " + isCorrectBrackets("()())(()"));
            System.out.println("Test 5: " + isCorrectBrackets("("));
            System.out.println("Test 6: " + isCorrectBrackets(")"));
            System.out.println("Test 7: " + isCorrectBrackets(""));
//            System.out.println("Test 8: " + isCorrectBrackets("(..)")); // check exception
//            System.out.println("Test 9: " + isCorrectBrackets(null)); // check exception
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean isCorrectBrackets(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("Строка не должна быть null.");
        }

        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    if (stack.empty()) {
                        return false;
                    }
                    stack.pop();
                }
                default -> throw new IllegalArgumentException("Строка должна содержать только символы '(' и ')'.");
            }
        }

        return stack.empty();
    }
}
