package HomeWork1.Task1;

/*
Создать собственное исключение MyCheckedException, являющееся проверяемым
 */
public class MyCheckedException extends ReflectiveOperationException {
    public MyCheckedException(String message) {
        super(message);
        System.out.println("MyCheckedException: " + message);
    }

    public static void main(String[] args) {
        try {
            throw new MyCheckedException("What a problem?");
        } catch (MyCheckedException ex) {
            ex.getStackTrace();
        }
    }
}
