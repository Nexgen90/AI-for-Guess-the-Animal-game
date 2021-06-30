package validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
public class AnimalInputValidator {
    Logger logger = LoggerFactory.getLogger(AnimalInputValidator.class);

    /**
     * @param animal - just animal name without article
     */
    public boolean isValid(String animal) {
        if (animal == null || animal.isBlank()){
            logger.info("Input string is blank");
            return false;
        }

        if (animal.trim().length() <= 2) {
            logger.info("Too small animal name");
            return false;
        }

        return true;
    }
}
