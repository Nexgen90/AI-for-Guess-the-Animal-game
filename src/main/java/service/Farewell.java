package service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
public class Farewell {
    private final ThreadLocalRandom random;

    public Farewell(ThreadLocalRandom random) {
        this.random = random;
    }

    public String getGoodbyeString() {
        int i = random.nextInt(0, 3);

        if (i == 0) {
            return "Thank you and Goodbye";
        }

        if (i == 1) {
            return "See you soon";
        }

        return "Bye";
    }
}
