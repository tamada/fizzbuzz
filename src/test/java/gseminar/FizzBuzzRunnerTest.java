package gseminar;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FizzBuzzRunnerTest{
    @Test
    public void testLengthByStream(){
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzListByStream(40);
        assertThat(items.size(), is(40));
    }

    @Test
    public void testLength(){
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzList(40);
        assertThat(items.size(), is(40));
    }

    @Test
    public void testDefaultLength(){
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzList();
        assertThat(items.size(), is(30));
    }
}
