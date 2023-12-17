import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerDecodeTest {

    @Test
    void checkEmptyString() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(""));
    }

    @Test
    void numberIsNotGreaterThanMaxInteger() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(String.valueOf((long) Integer.MAX_VALUE + 1)));
    }

    @Test
    void numberIsNotLessThanMinInteger() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(String.valueOf((long) Integer.MIN_VALUE - 1)));
    }

    @Test
    void correctParsePositiveNumber() {
        Assertions.assertEquals(
                Integer.decode("500"),
                500);
    }

    @Test
    void correctParseNegativeNumber() {
        Assertions.assertEquals(
                Integer.decode("-2000"),
                -2000);
    }

    @Test
    void allCharsInStringAreDigits() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> Integer.decode("text"));
    }

    @Test
    void nullStringParsing() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> Integer.decode(null));
    }

    @Test
    void checkZeroStart() {
        Assertions.assertEquals(
                Integer.decode("0001"),
                1);
    }
}