package enterNumbers;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayDeque<Integer> numbers = new ArrayDeque<>();


    public static void main(String[] args) {
        while (numbers.size() < 10) {
            try {
                readNumber(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException exception) {
                System.out.println("Invalid Number!");
            }
        }
        for(Iterator<Integer> descItr = numbers.descendingIterator(); descItr.hasNext();) {
            Integer number = descItr.next();
            if (!descItr.hasNext()){
                System.out.println(number);
                break;
            }
            System.out.print(number + ", ");
        }

    }

    private static void readNumber(int number) {
        if (numbers.size() == 0) {
            if (number <= 1 || number >= 100) {
                System.out.println("Your number is not in range 1 - 100!");
            } else {
                numbers.push(number);
            }
        } else {
            if (number < 100 && numbers.peek() < number && number > 1) {
                numbers.push(number);
            } else {
                System.out.printf("Your number is not in range %d - 100!%n", numbers.peek());
            }
        }
    }


}
