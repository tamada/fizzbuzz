package gseminar;

import java.io.PrintWriter;
import java.util.Objects;

public abstract class FizzBuzzItem {
    public void print(PrintWriter out) {
        out.println(toString());
    }

    public static FizzBuzzItem of(int value){
        if(value % 15 == 0) 
            return new StringItem("FizzBuzz");
        else if(value % 3 == 0)
            return new StringItem("Fizz");
        else if(value % 5 == 0)
            return new StringItem("Buzz");
        else
            return new IntItem(value);
    }

    public abstract String toString();

    private static class StringItem extends FizzBuzzItem {
        private String item;

        public StringItem(String item){
            this.item = item;
        }

        @Override
        public String toString(){
            return item;
        }

        public int hashCode(){
            return Objects.hash(getClass(), item);
        }

        public boolean equals(Object object) {
            return object instanceof StringItem
                && Objects.equals(((StringItem)object).item, item);
        }
    }

    private static class IntItem extends FizzBuzzItem {
        private int item;

        public IntItem(int item){
            this.item = item;
        }

        @Override
        public String toString(){
            return Integer.toString(item);
        }

        public int hashCode(){
            return Objects.hash(getClass(), item);
        }

        public boolean equals(Object object) {
            return object instanceof IntItem
                && item == ((IntItem)object).item;
        }
    }
}
