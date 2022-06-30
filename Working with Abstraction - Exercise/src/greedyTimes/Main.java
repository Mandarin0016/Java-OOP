
package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] treasure = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> treasureGained = new LinkedHashMap<>();

        for (int i = 0; i < treasure.length; i += 2) {
            String currentItem = treasure[i];
            long count = Long.parseLong(treasure[i + 1]);

            String result = "";

            result = getItem(currentItem, result);

            long currentCapacity = treasureGained.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count;
            if (result.isEmpty() || bagCapacity < currentCapacity) {
                continue;
            }

            switch (result) {
                case "Gem":
                    if (!treasureGained.containsKey(result)) {
                        if (treasureGained.containsKey("Gold")) {
                            if (count > treasureGained.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (treasureGained.get(result).values().stream().mapToLong(e -> e).sum() + count > treasureGained.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!treasureGained.containsKey(result)) {
                        if (treasureGained.containsKey("Gem")) {
                            if (count > treasureGained.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (treasureGained.get(result).values().stream().mapToLong(e -> e).sum() + count > treasureGained.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!treasureGained.containsKey(result)) {
                treasureGained.put((result), new LinkedHashMap<>());
            }

            if (!treasureGained.get(result).containsKey(currentItem)) {
                treasureGained.get(result).put(currentItem, 0L);
            }
            treasureGained.get(result).put(currentItem, treasureGained.get(result).get(currentItem) + count);
        }

        for (var x : treasureGained.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static String getItem(String currentItem, String result) {
        if (currentItem.length() == 3) {
            result = "Cash";
        } else if (currentItem.toLowerCase().endsWith("gem")) {
            result = "Gem";
        } else if (currentItem.equalsIgnoreCase("gold")) {
            result = "Gold";
        }
        return result;
    }
}