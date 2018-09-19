package gseminar;

import java.io.PrintWriter;
import java.util.Objects;

public abstract class FizzBuzzItem {
    public abstract void print(PrintWriter out);

    public static FizzBuzzItem of(int value){
        if(value % 15 == 0) 
            return new FizzBuzzStringItem("FizzBuzz");
        else if(value % 3 == 0)
            return new FizzBuzzStringItem("Fizz");
        else if(value % 5 == 0)
            return new FizzBuzzStringItem("Buzz");
        else
            return new FizzBuzzIntItem(value);
    }

    public abstract String toString();

    private static class FizzBuzzStringItem extends FizzBuzzItem {
        private String item;

        public FizzBuzzStringItem(String item){
            this.item = item;
        }

        public void print(PrintWriter out) {
            out.println(item);
        }

        @Override
        public String toString(){
            return item;
        }

        public int hashCode(){
            return Objects.hash(getClass(), item);
        }

        public boolean equals(Object object) {
            return object instanceof FizzBuzzStringItem
                && Objects.equals(((FizzBuzzStringItem)object).item, item);
        }
    }

    private static class FizzBuzzIntItem extends FizzBuzzItem {
        private int item;

        public FizzBuzzIntItem(int item){
            this.item = item;
        }

        @Override
        public String toString(){
            return Integer.toString(item);
        }

        public void print(PrintWriter out) {
            out.println(item);
        }

        public int hashCode(){
            return Objects.hash(getClass(), item);
        }

        public boolean equals(Object object) {
            return object instanceof FizzBuzzIntItem
                && item == ((FizzBuzzIntItem)object).item;
        }
    }
}
