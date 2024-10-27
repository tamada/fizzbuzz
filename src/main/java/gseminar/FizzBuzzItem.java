package gseminar;

import java.io.PrintWriter;

public abstract class FizzBuzzItem {
    public void print(PrintWriter out) {
        out.println(toString());
    }

    public abstract String toString();

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

    private static class StringItem extends FizzBuzzItem {
        private String item;

        public StringItem(String item){
            this.item = item;
        }

        @Override
        public String toString(){
            return item;
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
    }
}
