package service.learning;

import service.Clarification;
import service.Farewell;
import service.Greeting;
import text.AnswerResult;
import text.AnswerUtil;
import text.NameUtil;
import validator.AnimalInputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalTime;

import static text.AnswerResult.NO;
import static text.AnswerResult.UNKNOWN;
import static text.AnswerResult.YES;

/**
 * Created by nikolay.mikutskiy
 * Date: 01.07.2021
 */
public class AnimalNames {
    private final Greeting greeting;
    private final BufferedReader reader;
    private final NameUtil nameUtil;
    private final AnswerUtil answerUtil;
    private final AnimalInputValidator validator;
    private final Clarification clarification;
    private final Farewell farewell;

    public AnimalNames(Greeting greeting, BufferedReader reader, NameUtil nameUtil,
                       AnswerUtil answerUtil, AnimalInputValidator validator,
                       Clarification clarification, Farewell farewell) {
        this.greeting = greeting;
        this.reader = reader;
        this.nameUtil = nameUtil;
        this.answerUtil = answerUtil;
        this.validator = validator;
        this.clarification = clarification;
        this.farewell = farewell;
    }

    public void start() throws IOException {
        String timeBasedGreeting = greeting.getTimeBasedGreeting(LocalTime.now());
        System.out.println(timeBasedGreeting + "!");

        while (true) {
            System.out.println("Enter an animal:");
            System.out.print("> ");

            String animal = reader.readLine();
            boolean isValidAnimalName = validator.isValid(animal);
            if (!isValidAnimalName) {
                System.out.println(animal + " is incorrect animal name");
                continue;
            }
            String article = nameUtil.getFixedArticle(animal);
            String name = nameUtil.getNameWithoutArticle(animal);
            System.out.println("Is it " + article + " " + name + "?");

            boolean isAnswerFinished = false;
            while (!isAnswerFinished) {
                System.out.print("> ");
                String answer = reader.readLine();
                AnswerResult answerResult = answerUtil.parseAnswer(answer);

                if (answerResult == YES) {
                    System.out.println("You answered: Yes");
                    System.out.println("\n" + farewell.getGoodbyeString() + "!");
                    isAnswerFinished = true;
                    continue;
                }

                if (answerResult == NO) {
                    System.out.println("You answered: No");
                    System.out.println("\n" + farewell.getGoodbyeString() + "!");
                    isAnswerFinished = true;
                    continue;
                }

                if (answerResult == UNKNOWN) {
                    System.out.println(clarification.getClarificationText());
                }
            }

            System.out.println("\n");
        }
    }
}
