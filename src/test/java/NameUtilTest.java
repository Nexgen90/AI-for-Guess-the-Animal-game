import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import text.NameUtil;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
public class NameUtilTest {
    private NameUtil nameUtil = new NameUtil();


    @ParameterizedTest
    @MethodSource("articles")
    void shouldChooseCorrectArticle(String inputtedAnimal, String expectedArticle) {
        assertThat(nameUtil.getFixedArticle(inputtedAnimal), is(expectedArticle));
    }

    static Stream<Arguments> articles() {
        return Stream.of(
                Arguments.of("a cat", "a"),
                Arguments.of("the cat", "a"),
                Arguments.of("cat", "a"),
                Arguments.of("ape", "an"),
                Arguments.of("the ape", "an"),
                Arguments.of("an elephan", "an"),
                Arguments.of("a unicorn", "a"),
                Arguments.of("a xantic sargo", "a"),
                Arguments.of("an xeme", "a")

        );
    }

    @ParameterizedTest
    @MethodSource("animal")
    void shouldChooseCorrectName(String inputtedAnimal, String expectedName) {
        assertThat(nameUtil.getNameWithoutArticle(inputtedAnimal), is(expectedName));
    }

    static Stream<Arguments> animal() {
        return Stream.of(
                Arguments.of("a cat", "cat"),
                Arguments.of("the cat", "cat"),
                Arguments.of("cat", "cat"),
                Arguments.of("ape", "ape"),
                Arguments.of("the ape", "ape"),
                Arguments.of("an elephan", "elephan"),
                Arguments.of("a unicorn", "unicorn"),
                Arguments.of("a xantic sargo", "xantic sargo"),
                Arguments.of("an xeme", "xeme")
        );
    }
}
