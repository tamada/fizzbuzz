package gseminar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FizzBuzzMainTest{
    @Test
    public void testException1() throws Exception {
        assertThrows(RequiredValueMissingException.class, () -> 
            new FizzBuzzMain().run(new String[0], null)
        );
    }

    @Test
    public void testException2() throws Exception {
        assertThrows(TooManyArgumentsException.class, () -> 
            new FizzBuzzMain().run(new String[3], null)
        );
    }

    @Test
    public void testException3() {
        assertThrows(NumberFormatException.class, () -> 
            new FizzBuzzMain().run(new String[] { "string" }, null)
        );
    }

    @Test
    public void testBasic() {
        FizzBuzzMain main = new FizzBuzzMain();
        StringWriter out = new StringWriter();
        main.run(new String[] { "15" }, new PrintWriter(out));
        assertEquals(String.join(System.getProperty("line.separator"), "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(",")),
                out.toString().trim());
    }

    @Test
    public void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(out));
        PrintStream pout = new PrintStream(out);
        FizzBuzzMain.main(new String[] { "15" });
        pout.close();
        assertEquals(String.join(System.getProperty("line.separator"), "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(",")),
                new String(out.toByteArray()).trim());
    }
}
