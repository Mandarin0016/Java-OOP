package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static String[] data = null;
    private static final Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        executeCommand();
        while (!data[0].equals("END")) {
            applyMethod(blackBoxInt, data[0], Integer.parseInt(data[1]));
            executeCommand();
        }
    }

    private static void applyMethod(BlackBoxInt blackBoxInt, String methodName, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(blackBoxInt, value);
        Field field = blackBoxIntClass.getDeclaredField("innerValue");
        field.setAccessible(true);
        System.out.println(field.get(blackBoxInt));
    }

    private static void executeCommand() {
        data = scanner.nextLine().split("_");
    }
}
