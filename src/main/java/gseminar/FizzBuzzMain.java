package gseminar;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List; 

public class FizzBuzzMain {
    public void run(String[] args, PrintWriter out) throws IOException {
        if(args.length != 1)
            throw suitableException(args.length);
        runFizzBuzz(Integer.parseInt(args[0]), out);
    }

    private RuntimeException suitableException(int argsLength) {
        if(argsLength == 0)
            return new RequiredValueMissingException("No arguments are given");
        return new TooManyArgumentsException("Too many arguments");
    }

    private void runFizzBuzz(int max, PrintWriter out) {
        FizzBuzzRunner runner = new FizzBuzzRunner();
        List<FizzBuzzItem> items = runner.createFizzBuzzList(max);
        printResult(items, out);
    }

    private void printResult(List<FizzBuzzItem> items, PrintWriter out){
        items.stream()
            .forEach(item -> item.print(out));
        // for(FizzBuzzItem item: items){
        //     item.print(out);
        // }
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        FizzBuzzMain main = new FizzBuzzMain();
        main.run(args, new PrintWriter(new OutputStreamWriter(System.out, "utf-8")));
    }
}
