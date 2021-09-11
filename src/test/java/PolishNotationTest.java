import com.sinch.PolishNotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolishNotationTest {

    @Test
    @DisplayName("Valid operator")
    void testCalculateSuccess() {
        assertEquals(8.0, PolishNotation.calculate(2, 6, '+'),
                "Got addition of two values");
    }

    @Test
    @DisplayName("Invalid operator")
    void testCalculateFailure() {
        assertEquals(0.0, PolishNotation.calculate(2, 6, '.'),
                "No valid operator found, return zero");
    }

}
