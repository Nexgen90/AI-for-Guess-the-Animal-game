package text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
public class AnswerUtil {
    Logger logger = LoggerFactory.getLogger(AnswerUtil.class);


    public AnswerResult parseAnswer(String text) {
        if (isPositiveAnswer(text.trim())) return AnswerResult.YES;
        if (isNegativeAnswer(text.trim())) return AnswerResult.NO;

        return AnswerResult.UNKNOWN;
    }

    private boolean isPositiveAnswer(String text) {
        if (text.equalsIgnoreCase("y")) return true;
        if (text.equalsIgnoreCase("yes")) return true;
        if (text.equalsIgnoreCase("yeah")) return true;
        if (text.equalsIgnoreCase("yep")) return true;
        if (text.equalsIgnoreCase("sure")) return true;
        if (text.equalsIgnoreCase("right")) return true;
        if (text.equalsIgnoreCase("affirmative")) return true;
        if (text.equalsIgnoreCase("correct")) return true;
        if (text.equalsIgnoreCase("indeed")) return true;
        if (text.equalsIgnoreCase("you bet")) return true;
        if (text.equalsIgnoreCase("exactly")) return true;
        return text.equalsIgnoreCase("you said it");
    }
    private boolean isNegativeAnswer(String text) {
        if (text.equalsIgnoreCase("n")) return true;
        if (text.equalsIgnoreCase("no")) return true;
        if (text.equalsIgnoreCase("no way")) return true;
        if (text.equalsIgnoreCase("nah")) return true;
        if (text.equalsIgnoreCase("nope")) return true;
        if (text.equalsIgnoreCase("negative")) return true;
        if (text.equalsIgnoreCase("I don't think so")) return true;
        return text.equalsIgnoreCase("yeah no");
    }

}
