package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

/**
 * Created by nikolay.mikutskiy
 * Date: 29.06.2021
 */
public class Greeting {
    Logger logger = LoggerFactory.getLogger(Greeting.class);

    public String getTimeBasedGreeting(LocalTime time) {
        int currentHour = time.getHour();
        logger.info("time.getHour() = {}", currentHour);
        return getGreetingStartWord(currentHour);
    }

    private String getGreetingStartWord(int hour) {
        if (hour >=  5 && hour < 12) return "Good morning";
        if (hour >=  12 && hour < 18) return "Good afternoon";
        if (hour >=  18 && hour < 23) return "Good evening";
        if (hour >=  23 && hour <= 24) return "Hi, Night Owl";
        if (hour >=  0 && hour < 4) return "Hi, Night Owl";
        if (hour == 4) return "Hi, Early Bird";
        return "Hello";
    }
}
