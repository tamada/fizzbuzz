package gseminar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RequiredValueMissingExceptionTest {
    private Exception exception;

    @BeforeEach
    public void setUp() {
        this.exception = new RequiredValueMissingException("message");
    }

    @Test
    void testBasic(){
        assertInstanceOf(RequiredValueMissingException.class, exception);
        assertEquals("message", exception.getMessage());
    }
}
