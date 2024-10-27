package gseminar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

class FizzBuzzMainTest{
    @Test
    void testException1() {
        assertThrows(RequiredValueMissingException.class, () -> 
            new FizzBuzzMain().run(new String[0], null)
        );
    }

    @Test
    void testException2() {
        assertThrows(TooManyArgumentsException.class, () -> 
            new FizzBuzzMain().run(new String[3], null)
        );
    }

    @Test
    void testException3() {
        assertThrows(NumberFormatException.class, () -> 
            new FizzBuzzMain().run(new String[] { "string" }, null)
        );
    }

    @Test
    void testBasic() {
        FizzBuzzMain main = new FizzBuzzMain();
        StringWriter out = new StringWriter();
        main.run(new String[] { "15" }, new PrintWriter(out));
        assertEquals(String.join(System.getProperty("line.separator"), "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(",")),
                out.toString().trim());
    }

    @Test
    void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(out));
        PrintStream pout = new PrintStream(out);
        FizzBuzzMain.main(new String[] { "15" });
        pout.close();
        assertEquals(String.join(System.getProperty("line.separator"), "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(",")),
                new String(out.toByteArray()).trim());
    }
}
