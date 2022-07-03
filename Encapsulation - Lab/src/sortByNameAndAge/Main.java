package sortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int currentPerson = 0; currentPerson < numberOfPeople; currentPerson++) {
            String[] currentPersonData = reader.readLine().split(" ");
            people.add(new Person(currentPersonData[0], currentPersonData[1], Integer.parseInt(currentPersonData[2])));
        }

        Collections.sort(people, Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}
