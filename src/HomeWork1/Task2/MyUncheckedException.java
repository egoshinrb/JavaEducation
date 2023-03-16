package HomeWork1.Task2;

/*
Создать собственное исключение MyUncheckedException, являющееся непроверяемым
 */
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
        System.out.println("MyUncheckedException: " + message);
    }

    public static void main(String[] args) {
        try {
            throw new MyUncheckedException("What a problem?");
        } catch (MyUncheckedException ex) {
            ex.getStackTrace();
        }
    }
}
