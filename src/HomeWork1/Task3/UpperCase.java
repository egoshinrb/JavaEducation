package HomeWork1.Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Реализовать метод, открывающий файл ./input.txt и сохраняющий в файл ./output.txt текст из input,
где каждый латинский строчный символ заменен на соответствующий заглавный.
Обязательно использование try с ресурсами
 */
public class UpperCase {
    public static final String DIRECTORY = "C:\\Users\\stadm\\IdeaProjects\\SberUnivercity\\src\\AdvHomeWork1\\Task3\\";
    public static final String INPUT_FILE_NAME = "input.txt";
    public static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {
        fileUpperCase();
    }

    public static void fileUpperCase() {
        try (Scanner scanner = new Scanner(new File(DIRECTORY + INPUT_FILE_NAME));
             PrintWriter writer = new PrintWriter(DIRECTORY + OUTPUT_FILE_NAME)) {
            while (scanner.hasNext()) {
                writer.write(scanner.next().toUpperCase() + "\n");
            }
        } catch (FileNotFoundException exception) {
            System.out.println("LOG: " + exception.getMessage());
        }
    }
}
