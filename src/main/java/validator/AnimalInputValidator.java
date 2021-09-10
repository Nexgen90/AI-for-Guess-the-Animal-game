package validator;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
@Slf4j
public class AnimalInputValidator {
    
    /**
     * @param animal - just animal name without article
     */
    public boolean isValid(String animal) {
        if (animal == null || animal.isBlank()){
            log.debug("Input string is blank");
            return false;
        }

        if (animal.trim().length() <= 2) {
            log.debug("Too small animal name");
            return false;
        }

        return true;
    }
}
