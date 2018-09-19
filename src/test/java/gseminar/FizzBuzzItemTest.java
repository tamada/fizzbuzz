package gseminar;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class FizzBuzzItemTest{
    @Test
    public void testIndex(){
        FizzBuzzItem item = FizzBuzzItem.of(1);
        assertThat(item.toString(), is("1"));
    }

    @Test
    public void testFizz(){
        FizzBuzzItem item = FizzBuzzItem.of(3);
        assertThat(item.toString(), is("Fizz"));
    }

    @Test
    public void testBuzz(){
        FizzBuzzItem item = FizzBuzzItem.of(5);
        assertThat(item.toString(), is("Buzz"));
    }

    @Test
    public void testFizzBuzz(){
        FizzBuzzItem item = FizzBuzzItem.of(15);
        assertThat(item.toString(), is("FizzBuzz"));
    }

    @Test
    public void testEquals1(){
        FizzBuzzItem item = FizzBuzzItem.of(15);
        assertThat(item, is(FizzBuzzItem.of(30)));
        assertThat(item.hashCode(), is(FizzBuzzItem.of(30).hashCode()));
    }

    @Test
    public void testEquals2(){
        FizzBuzzItem item = FizzBuzzItem.of(3);
        assertThat(item, is(FizzBuzzItem.of(9)));
        assertThat(item.hashCode(), is(FizzBuzzItem.of(9).hashCode()));
    }

    @Test
    public void testEquals3(){
        FizzBuzzItem item = FizzBuzzItem.of(5);
        assertThat(item, is(FizzBuzzItem.of(20)));
        assertThat(item.hashCode(), is(FizzBuzzItem.of(20).hashCode()));
    }

    /**
     * 意味のないテスト．
     * カバレッジを挙げるためにしても頭悪い．
     */
    @Test
    public void testEquals4(){
        FizzBuzzItem item = FizzBuzzItem.of(4);
        assertThat(item, is(FizzBuzzItem.of(4)));
        assertThat(item.hashCode(), is(FizzBuzzItem.of(4).hashCode()));
    }

    @Test
    public void testNotEquals(){
        FizzBuzzItem item = FizzBuzzItem.of(5);
        assertThat(item, is(not(new Object())));
        assertThat(item, is(not(FizzBuzzItem.of(30))));
    }

    @Test
    public void testNotEqualsFizzBuzzIntItem(){
        FizzBuzzItem item = FizzBuzzItem.of(7);
        assertThat(item, is(not(new Object())));
        assertThat(item, is(not(FizzBuzzItem.of(10))));
        assertThat(item, is(not(FizzBuzzItem.of(11))));
    }
}
