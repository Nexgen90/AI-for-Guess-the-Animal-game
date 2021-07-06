package validator;

/**
 * Created by nikolay.mikutskiy
 * Date: 05.07.2021
 */
public class DistinguishesValidator {
    public boolean isValid(String distinguish) {

        boolean isCorrectBeginning = distinguish.trim().startsWith("It can ")
                || distinguish.startsWith("It has ")
                || distinguish.startsWith("It is ");

        String[] words = distinguish.trim().split(" ");
        boolean isFilledDistinguish = words.length >= 3 && !words[2].isBlank();

        return isCorrectBeginning && isFilledDistinguish;
    }
}
