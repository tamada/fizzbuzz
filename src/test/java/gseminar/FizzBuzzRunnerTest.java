package gseminar;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzRunnerTest{
    @Test
    public void testLengthByStream(){
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzListByStream(40);
        assertEquals(40, items.size());
    }

    @Test
    public void testLength(){
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzList(40);
        assertEquals(40, items.size());
    }

    @Test
    public void testDefaultLength(){
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzList();
        assertEquals(30, items.size());
    }
}
