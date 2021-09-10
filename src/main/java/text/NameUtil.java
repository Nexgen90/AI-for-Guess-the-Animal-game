package text;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
@Slf4j
public class NameUtil {

    public String getFixedArticle(String text) {
        String[] wordWithArticle = text.trim().split(" ");
        if (wordWithArticle.length == 1) {
            String exception = getArticleIfWordInExceptionList(text);
            if (exception != null) {
                return exception;
            }

            boolean isVowel = isVowel(text.charAt(0));
            if (isVowel) {
                return "an";
            } else {
                return "a";
            }
        }

        String animalNameWithoutArticle = Arrays.stream(wordWithArticle)
                .skip(1).collect(Collectors.joining(" "));
        log.debug("word <{}> with article <{}>", animalNameWithoutArticle, wordWithArticle[0]);

        String exception = getArticleIfWordInExceptionList(animalNameWithoutArticle);
        if (exception != null) {
            return exception;
        }

        boolean isVowel = isVowel(wordWithArticle[1].charAt(0));
        if (isVowel) {
            return "an";
        } else {
            return "a";
        }
    }

    public String getNameWithoutArticle(String text) {
        String[] wordWithArticle = text.trim().split(" ");
        if (wordWithArticle.length == 1) {
            return wordWithArticle[0];
        }

        return Arrays.stream(wordWithArticle)
                .filter(t -> !t.equalsIgnoreCase("the"))
                .filter(t -> !t.equalsIgnoreCase("a"))
                .filter(t -> !t.equalsIgnoreCase("an"))
                .collect(Collectors.joining(" "));
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            log.debug("{} is vowel", ch);
            return true;
        } else {
            log.debug("{} is consonant", ch);
            return false;
        }
    }

    private String getArticleIfWordInExceptionList(String word) {
        switch (word.toLowerCase()) {
            case "unicorn":
                return "a";
            default:
                return null;
        }
    }

}
