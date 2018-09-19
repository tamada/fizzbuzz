package gseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class FizzBuzzRunner {
    public List<FizzBuzzItem> createFizzBuzzList(int max) {
        List<FizzBuzzItem> items = new ArrayList<>();
        for(int i = 1; i <= max; i++) {
            items.add(FizzBuzzItem.of(i));
        }
        return items;
    }

    public List<FizzBuzzItem> createFizzBuzzListByStream(int max) {
        return IntStream.rangeClosed(1, max)
            .mapToObj(FizzBuzzItem::of)
            .collect(Collectors.toList());
    }

    public List<FizzBuzzItem> createFizzBuzzList() {
        return createFizzBuzzList(30);
    }
}
