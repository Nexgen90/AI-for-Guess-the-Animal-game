package service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
public class Clarification {
    private final ThreadLocalRandom random;

    public Clarification(ThreadLocalRandom random) {
        this.random = random;
    }

    public String getClarificationText() {
        int r = random.nextInt(0, 5);
        switch (r) {
            case 0:
                return "I'm not sure I caught you: was it yes or no?";
            case 1:
                return "Funny, I still don't understand, is it yes or no?";
            case 2:
                return "Oh, it's too complicated for me: just tell me yes or no.";
            case 3:
                return "Could you please simply say yes or no?";
            case 4:
                return "Oh, no, don't try to confuse me: say yes or no.";
            default:
                return "yes or no?";
        }
    }
}
