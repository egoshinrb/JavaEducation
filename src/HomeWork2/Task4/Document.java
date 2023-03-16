package HomeWork2.Task4;

import java.util.*;
import java.util.stream.Collectors;

/*
В некоторой организации хранятся документы (см. класс Document).
Сейчас все документы лежат в ArrayList, из-за чего поиск по id документа выполняется неэффективно.
Для оптимизации поиска по id, необходимо помочь сотрудникам перевести хранение документов из ArrayList в HashMap.
 */
public class Document {
    public static void main(String[] args) {
        List<Document> list3 = Arrays.asList(new Document(1, "Roman", 35),
                new Document(2, "Mike", 21), new Document(3, "Mark", 57));
        System.out.println("list" + list3);

        try {
            System.out.println("map" + organizeDocuments(list3));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static Map<Integer, Document> organizeDocuments(List<Document> documents) throws IllegalArgumentException {
        if (documents == null || documents.contains(null)) {
            throw new IllegalArgumentException("Лист не должен быть null и не должен содержать null");
        }
        return documents.stream().collect(Collectors.toMap(Document::getId, document -> document));
    }


    private int id;
    private String name;
    private int pageCount;

    public Document() {
    }

    public Document(int id, String name, int pageCount) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "{" + id + ", " + name + ", " + pageCount + "}";
    }
}
