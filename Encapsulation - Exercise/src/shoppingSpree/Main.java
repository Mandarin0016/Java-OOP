package shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peopleInput = scanner.nextLine().split(";");
        String[] productsInput = scanner.nextLine().split(";");
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        try {
            Arrays.stream(peopleInput).forEach(personData -> people.add(new Person(personData.split("=")[0], Double.parseDouble(personData.split("=")[1]))));
            Arrays.stream(productsInput).forEach(productData -> products.add(new Product(productData.split("=")[0], Double.parseDouble(productData.split("=")[1]))));
            String data = scanner.nextLine();
            while (!data.equals("END")) {
                try {
                    for (Person person : people) {
                        if (person.getName().equals(data.split("\\s+")[0])) {
                            for (Product product : products) {
                                if (product.getName().equals(data.split("\\s+")[1])) {
                                    person.buyProduct(product);
                                    System.out.println(person.getName() + " bought " + product.getName() + " ");
                                }
                            }
                        }
                    }
                }catch (IllegalArgumentException exception){
                    System.out.println(exception.getMessage());
                }
                data = scanner.nextLine();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        for (Person person : people) {
            if (person.getBagSize() == 0) {
                System.out.println(person.getName() + " - " + "Nothing bought");
                continue;
            }
            System.out.println(person.getName() + " - " + String.join(", ", person.getProducts()));
        }

    }
}
