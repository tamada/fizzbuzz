package gseminar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzItemTest{
    @Test
    public void testFizzBuzzConversion(){
        assertEquals("1", FizzBuzzItem.of(1).toString());
        assertEquals("7", FizzBuzzItem.of(7).toString());
        assertEquals("13", FizzBuzzItem.of(13).toString());
        assertEquals("Fizz", FizzBuzzItem.of(3).toString());
        assertEquals("Fizz", FizzBuzzItem.of(9).toString());
        assertEquals("Buzz", FizzBuzzItem.of(5).toString());
        assertEquals("Buzz", FizzBuzzItem.of(25).toString());
        assertEquals("FizzBuzz", FizzBuzzItem.of(15).toString());
        assertEquals("FizzBuzz", FizzBuzzItem.of(30).toString());
    }
}
