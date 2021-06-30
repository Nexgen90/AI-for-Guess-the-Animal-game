import service.Clarification;
import service.Farewell;
import service.Greeting;
import text.AnswerResult;
import text.AnswerUtil;
import text.TextUtil;
import validator.AnimalInputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import static text.AnswerResult.NO;
import static text.AnswerResult.UNKNOWN;
import static text.AnswerResult.YES;

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
            String article = textUtil.getFixedArticle(animal);
            String name = textUtil.getNameWithoutArticle(animal);
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
