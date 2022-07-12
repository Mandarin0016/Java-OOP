package telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        setNumbers(numbers);
        setUrls(urls);
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }


    @Override
    public String browse() {
        return this.urls.stream().map(url -> url.matches("^[\\D]+$") ? "Browsing: " + url + "!" : "Invalid URL!").collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String call() {
        return this.numbers.stream().map(number -> number.matches("^[\\d]+$") ? "Calling... " + number : "Invalid number!").collect(Collectors.joining(System.lineSeparator()));
    }
}
