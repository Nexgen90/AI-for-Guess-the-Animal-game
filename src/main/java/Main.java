import service.Clarification;
import service.Farewell;
import service.Greeting;
import service.dto.Animal;
import service.dto.AnimalFact;
import text.AnswerResult;
import text.AnswerUtil;
import text.FactUtil;
import text.NameUtil;
import validator.AnimalInputValidator;
import validator.DistinguishesValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nikolay.mikutskiy
 * Date: 29.06.2021
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Greeting greeting = new Greeting();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NameUtil nameUtil = new NameUtil();
        AnswerUtil answerUtil = new AnswerUtil();
        AnimalInputValidator validator = new AnimalInputValidator();
        Clarification clarification = new Clarification(ThreadLocalRandom.current());
        Farewell farewell = new Farewell(ThreadLocalRandom.current());
        DistinguishesValidator distinguishesValidator = new DistinguishesValidator();
        FactUtil factUtil = new FactUtil();

        Animal firstAnimal = null;
        Animal secondAnimal = null;


        while (firstAnimal == null) {
            String input = getUserInput("Enter the first animal:", reader);
            if (!validator.isValid(input)) {
                System.out.println("Invalid animal name!");
                continue;
            }
            firstAnimal = new Animal(nameUtil.getFixedArticle(input), nameUtil.getNameWithoutArticle(input));
        }

        while (secondAnimal == null) {
            String input = getUserInput("Enter the second animal:", reader);
            if (!validator.isValid(input)) {
                System.out.println("Invalid animal name!");
                continue;
            }
            secondAnimal = new Animal(nameUtil.getFixedArticle(input), nameUtil.getNameWithoutArticle(input));
        }

        AnimalFact animalFact = new AnimalFact(firstAnimal, secondAnimal);

        String distinguish = null;
        while (distinguish == null) {
            String question = String.format("Specify a fact that distinguishes %s from %s.\n",
                    firstAnimal, secondAnimal);
            String input = getUserInput(question + "The sentence should be of the format: 'It can/has/is ...'.", reader);
            if (!distinguishesValidator.isValid(input)) {
                System.out.println("The examples of a statement:\n" +
                        " - It can fly\n" +
                        " - It has horn\n" +
                        " - It is a mammal");
                continue;
            }
            distinguish = input;
        }

        System.out.println("Is it correct for " + secondAnimal + "?");

        AnswerResult answerResult = null;
        while (answerResult == null) {
            String input = getUserInput(null, reader);

            AnswerResult inputtedAnswer = answerUtil.parseAnswer(input);
            if (inputtedAnswer == AnswerResult.UNKNOWN) {
                System.out.println(clarification.getClarificationText());
                continue;
            }
            answerResult = inputtedAnswer;
        }

        if (answerResult == AnswerResult.NO) {
            animalFact.setFirstAnimalStatement(factUtil.makePositiveStatement(distinguish, firstAnimal.getName()));
            animalFact.setSecondAnimalStatement(factUtil.makeNegativeStatement(distinguish, secondAnimal.getName()));
        } else {
            animalFact.setSecondAnimalStatement(factUtil.makePositiveStatement(distinguish, secondAnimal.getName()));
            animalFact.setFirstAnimalStatement(factUtil.makeNegativeStatement(distinguish, firstAnimal.getName()));
        }

        animalFact.setQuestionToDistinct(factUtil.makeQuestionFromFact(distinguish));

        System.out.println("I learned the following facts about animals:");
        System.out.println(" - " + animalFact.getFirstAnimalStatement());
        System.out.println(" - " + animalFact.getSecondAnimalStatement());

        System.out.println("I can distinguish these animals by asking the question:");
        System.out.println(" - " + animalFact.getQuestionToDistinct());

        System.out.println("\n" + farewell.getGoodbyeString());

    }

    private static String getUserInput(String text, BufferedReader reader) throws IOException {
        if (text != null && !text.isBlank()) {
            System.out.println(text);
        }
        System.out.print("> ");
        return reader.readLine();
    }
}
