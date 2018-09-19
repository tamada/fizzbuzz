package gseminar;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FizzBuzzMainTest{
    @Test(expected=RequiredValueMissingException.class)
    public void testException1() throws Exception {
        FizzBuzzMain main = new FizzBuzzMain();
        main.run(new String[0], null);
    }

    @Test(expected=TooManyArgumentsException.class)
    public void testException2() throws Exception {
        FizzBuzzMain main = new FizzBuzzMain();
        main.run(new String[3], null);
    }

    @Test(expected=NumberFormatException.class)
    public void testException3() throws Exception {
        FizzBuzzMain main = new FizzBuzzMain();
        main.run(new String[] { "string" }, null);
    }

    @Test
    public void testBasic() throws Exception {
        FizzBuzzMain main = new FizzBuzzMain();
        StringWriter out = new StringWriter();
        main.run(new String[] { "15" }, new PrintWriter(out));
        assertThat(out.toString().trim(),
                   is(String.join(System.getProperty("line.separator"), "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(","))));
    }

    @Test
    public void testMain() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(out));
        PrintStream pout = new PrintStream(out);
        FizzBuzzMain.main(new String[] { "15" });
        pout.close();
        assertThat(new String(out.toByteArray()).trim(),
                   is(String.join(System.getProperty("line.separator"), "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(","))));
    }
}
