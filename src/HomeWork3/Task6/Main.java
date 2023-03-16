package HomeWork3.Task6;

import java.util.Stack;

/*
Дана строка, состоящая из символов “(“, “)”, “{”, “}”, “[“, “]”
Необходимо написать метод, принимающий эту строку и выводящий результат,
является ли она правильной скобочной последовательностью или нет.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Test 1: " + isCorrectBrackets("{[()]}"));
            System.out.println("Test 2: " + isCorrectBrackets("{[()(){}[]]}"));
            System.out.println("Test 3: " + isCorrectBrackets("({)}"));
            System.out.println("Test 4: " + isCorrectBrackets("[{()]"));
            System.out.println("Test 5: " + isCorrectBrackets("{}}"));
            System.out.println("Test 6: " + isCorrectBrackets("]"));
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
        String openBrackets = "({[";
        String closeBrackets = ")}]";

        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (openBrackets.indexOf(c) != -1) {
                stack.push(c);
            } else if (closeBrackets.indexOf(c) != -1) {
                if (stack.empty() || stack.peek() != openBrackets.charAt(closeBrackets.indexOf(c))) {
                    return false;
                }
                stack.pop();
            } else {
                throw new IllegalArgumentException("Строка должна содержать только символы скобок.");
            }
        }

        return stack.empty();
    }
}
