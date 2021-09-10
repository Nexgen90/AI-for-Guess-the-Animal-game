package text;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by nikolay.mikutskiy
 * Date: 06.07.2021
 */
@Slf4j
public class FactUtil {
    private static final String CAN_STATEMENT = "It can ";
    private static final String HAS_STATEMENT = "It has ";
    private static final String IS_STATEMENT = "It is ";

    /**
     *
     * @param fact like "It can fly / It has horn / It is a mammal"
     * @return question like "Can it fly? / Does it have a horn? / Is it a mammal?"
     */
    public String makeQuestionFromFact(String fact) {
        if (fact.contains(CAN_STATEMENT)) {
            return fact.replace(CAN_STATEMENT, "Can it ") + "?";
        }

        if (fact.contains(HAS_STATEMENT)) {
            return fact.replace(HAS_STATEMENT, "Does it have ") + "?";
        }

        if (fact.contains(IS_STATEMENT)) {
            return fact.replace(IS_STATEMENT, "Is it ") + "?";
        }

        log.error("Can't make question from statement: <{}>", fact);
        return fact + "?";
    }

    /**
     * From "It can fly / It has horn / It is a mammal"
     * @return statement like "The {animal} can fly"
     */
    public String makePositiveStatement(String fact, String animal) {
        if (fact.contains(CAN_STATEMENT)) {
            return "The " + animal + fact.replace(CAN_STATEMENT, " can ");
        }

        if (fact.contains(HAS_STATEMENT)) {
            return "The " + animal + fact.replace(HAS_STATEMENT, " has ");
        }

        if (fact.contains(IS_STATEMENT)) {
            return "The " + animal + fact.replace(IS_STATEMENT, " is ");
        }

        log.error("Can't make positive statement from fact: <{}>", fact);
        return fact;
    }

    /**
     * From "It can fly / It has horn / It is a mammal"
     * @return statement like "The {animal} can't fly"
     */
    public String makeNegativeStatement(String fact, String animal) {
        if (fact.contains(CAN_STATEMENT)) {
            return "The " + animal + fact.replace(CAN_STATEMENT, " can't ");
        }

        if (fact.contains(HAS_STATEMENT)) {
            return "The " + animal + fact.replace(HAS_STATEMENT, " doesn't have ");
        }

        if (fact.contains(IS_STATEMENT)) {
            return "The " + animal + fact.replace(IS_STATEMENT, " isn't ");
        }

        log.error("Can't make negative statement from fact: <{}>", fact);
        return "Not " + fact;
    }
}
