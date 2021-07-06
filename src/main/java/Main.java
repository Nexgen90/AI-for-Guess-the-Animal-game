import service.Clarification;
import service.Farewell;
import service.Greeting;
import service.learning.Animal;
import service.learning.AnimalFact;
import text.AnswerResult;
import text.AnswerUtil;
import text.TextUtil;
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
        TextUtil textUtil = new TextUtil();
        AnswerUtil answerUtil = new AnswerUtil();
        AnimalInputValidator validator = new AnimalInputValidator();
        Clarification clarification = new Clarification(ThreadLocalRandom.current());
        Farewell farewell = new Farewell(ThreadLocalRandom.current());
        DistinguishesValidator distinguishesValidator = new DistinguishesValidator();

        Animal firstAnimal = null;
        Animal secondAnimal = null;


        while (firstAnimal == null) {
            System.out.println("Enter the first animal:");
            System.out.print("> ");
            String input = reader.readLine();
            if (!validator.isValid(input)) {
                System.out.println("Invalid animal name!");
                continue;
            }
            firstAnimal = new Animal(textUtil.getFixedArticle(input), textUtil.getNameWithoutArticle(input));
        }

        while (secondAnimal == null) {
            System.out.println("Enter the second animal:");
            System.out.print("> ");
            String input = reader.readLine();
            if (!validator.isValid(input)) {
                System.out.println("Invalid animal name!");
                continue;
            }
            secondAnimal = new Animal(textUtil.getFixedArticle(input), textUtil.getNameWithoutArticle(input));
        }

        AnimalFact animalFact = new AnimalFact(firstAnimal, secondAnimal);

        String distinguish = null;
        while (distinguish == null) {
            String question = String.format("Specify a fact that distinguishes %s from %s.\n",
                    firstAnimal, secondAnimal);
            System.out.println(question + "The sentence should be of the format: 'It can/has/is ...'.");
            System.out.print("> ");
            String input = reader.readLine();
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
            System.out.print("> ");
            String input = reader.readLine();

            AnswerResult inputtedAnswer = answerUtil.parseAnswer(input);
            if (inputtedAnswer == AnswerResult.UNKNOWN) {
                System.out.println(clarification.getClarificationText());
                continue;
            }
            answerResult = inputtedAnswer;
        }

        if (answerResult == AnswerResult.NO) {
            String fact = "The " + firstAnimal.getName() + " " + distinguish.substring(3);
            animalFact.setFirstAnimalStatement(fact);
            String fact2 = "The " + secondAnimal.getName() + " not " + distinguish.substring(3);
            animalFact.setSecondAnimalStatement(fact2);
        } else {
            String fact = "The " + secondAnimal.getName() + " " + distinguish.substring(3);
            animalFact.setSecondAnimalStatement(fact);
            String fact2 = "The " + firstAnimal.getName() + " not " + distinguish.substring(3);
            animalFact.setFirstAnimalStatement(fact2);
        }
        animalFact.setQuestionToDistinct(distinguish + "?");

        //> It is a mammal
        //I learned the following facts about animals:
        // - The cat is a mammal.
        // - The shark isn't a mammal.
        //I can distinguish these animals by asking the question:
        // - Is it a mammal?
        System.out.println("I learned the following facts about animals:");
        System.out.println(" - " + animalFact.getFirstAnimalStatement());
        System.out.println(" - " + animalFact.getSecondAnimalStatement());

        System.out.println("I can distinguish these animals by asking the question:");
        System.out.println(" - " + animalFact.getQuestionToDistinct());



    }
}
