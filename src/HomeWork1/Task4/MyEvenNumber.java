package HomeWork1.Task4;

/*
Создать класс MyEvenNumber, который хранит четное число int n.
Используя исключения, запретить создание инстанса MyEvenNumber с нечетным числом.
 */
public class MyEvenNumber {
    public static void main(String[] args) {
        try {
            MyEvenNumber x = new MyEvenNumber(5);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private int number;

    public MyEvenNumber() {
    }

    public MyEvenNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException("Число должно быть четным");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
