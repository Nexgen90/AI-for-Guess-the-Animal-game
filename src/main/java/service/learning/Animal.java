package service.learning;

/**
 * Created by nikolay.mikutskiy
 * Date: 05.07.2021
 */
public class Animal {
    private final String article;
    private final String name;

    public Animal(String article, String name) {
        this.name = name;
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public String getArticle() {
        return article;
    }

    @Override
    public String toString() {
        return article + " " + name;
    }
}
