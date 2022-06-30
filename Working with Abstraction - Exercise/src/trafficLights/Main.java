package trafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] myLights = scanner.nextLine().split("\\s+");
        Lights[] lights = Lights.values();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < myLights.length; j++) {
                String currentLight = myLights[j];
                int newLightOrdinal= Lights.valueOf(currentLight).ordinal() + 1;
                if (newLightOrdinal >= lights.length){
                    newLightOrdinal = 0;
                }
                myLights[j] = lights[newLightOrdinal].toString();
            }
            System.out.println(String.join(" ", myLights));
        }
    }
}
