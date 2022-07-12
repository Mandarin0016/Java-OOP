package collectionHierarchy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Addable addableCollection = new AddCollection();
    private static final AddRemovable addRemovableCollection = new AddRemoveCollection();
    private static final MyList myListCollection = new MyListImpl();
    public static void main(String[] args) {
        fillCollections(scanner.nextLine().split("\\s+"));
        removeItemsFromCollections(Integer.parseInt(scanner.nextLine().split("\\s+")[0]));
    }

    private static void removeItemsFromCollections(int removeOperationsNumber) {
        removeFromAddRemovableCollection(removeOperationsNumber);
        removeFromMyListCollection(removeOperationsNumber);
    }

    private static void removeFromAddRemovableCollection(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(addRemovableCollection.remove() + " ");
        }
        System.out.println();
    }
    private static void removeFromMyListCollection(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(myListCollection.remove() + " ");
        }
        System.out.println();
    }

    private static void fillCollections(String[] items) {
        fillAddableCollection(items);
        fillAddRemovableCollection(items);
        fillMyListCollection(items);

    }

    private static void fillMyListCollection(String[] items) {
        Arrays.stream(items).forEach(item -> System.out.print(myListCollection.add(item) + " "));
        System.out.println();
    }

    private static void fillAddRemovableCollection(String[] items) {
        Arrays.stream(items).forEach(item -> System.out.print(addRemovableCollection.add(item) + " "));
        System.out.println();
    }

    private static void fillAddableCollection(String[] items) {
        Arrays.stream(items).forEach(item -> System.out.print(addableCollection.add(item) + " "));
        System.out.println();
    }
}
