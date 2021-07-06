package service.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay.mikutskiy
 * Date: 01.07.2021
 */
public class AnimalFact {
    private Animal firstAnimal;
    private Animal secondAnimal;
    private String firstAnimalStatement;
    private String secondAnimalStatement;
    private String questionToDistinct;

    public AnimalFact(Animal firstAnimal, Animal secondAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
    }

    public Animal getFirstAnimal() {
        return firstAnimal;
    }

    public Animal getSecondAnimal() {
        return secondAnimal;
    }

    public String getFirstAnimalStatement() {
        return firstAnimalStatement;
    }

    public void setFirstAnimalStatement(String firstAnimalStatement) {
        this.firstAnimalStatement = firstAnimalStatement;
    }

    public String getSecondAnimalStatement() {
        return secondAnimalStatement;
    }

    public void setSecondAnimalStatement(String secondAnimalStatement) {
        this.secondAnimalStatement = secondAnimalStatement;
    }

    public String getQuestionToDistinct() {
        return questionToDistinct;
    }

    public void setQuestionToDistinct(String questionToDistinct) {
        this.questionToDistinct = questionToDistinct;
    }
}
