package gseminar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TooManyArgumentsExceptionTest {
    private Exception exception;

    @BeforeEach
    public void setUp() {
        this.exception = new TooManyArgumentsException("message");
    }

    @Test
    public void testBasic(){
        assertInstanceOf(TooManyArgumentsException.class, exception);
        assertEquals("message", exception.getMessage());
    }
}
