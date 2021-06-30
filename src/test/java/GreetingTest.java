import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.Greeting;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by nikolay.mikutskiy
 * Date: 30.06.2021
 */
class GreetingTest {

    Greeting greeting = new Greeting();

    @ParameterizedTest
    @MethodSource("times")
    void shouldGetTimeBasedGreeting(LocalTime time, String expectedGreeting) {
        assertThat(greeting.getTimeBasedGreeting(time), is(expectedGreeting));
    }

    static Stream<Arguments> times() {
        return Stream.of(
                Arguments.of(LocalTime.of(5, 0), "Good morning"),
                Arguments.of(LocalTime.of(6, 20), "Good morning"),
                Arguments.of(LocalTime.of(11, 59), "Good morning"),
                Arguments.of(LocalTime.of(12, 0), "Good afternoon"),
                Arguments.of(LocalTime.of(14, 30), "Good afternoon"),
                Arguments.of(LocalTime.of(17, 59), "Good afternoon"),
                Arguments.of(LocalTime.of(18, 0), "Good evening"),
                Arguments.of(LocalTime.of(23, 59), "Hi, Night Owl"),
                Arguments.of(LocalTime.of(0, 0), "Hi, Night Owl"),
                Arguments.of(LocalTime.of(3, 59), "Hi, Night Owl"),
                Arguments.of(LocalTime.of(4, 0), "Hi, Early Bird"),
                Arguments.of(LocalTime.of(4, 59), "Hi, Early Bird")
        );
    }
}