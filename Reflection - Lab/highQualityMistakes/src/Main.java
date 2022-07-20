import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Reflection> reflectionClass = Reflection.class;

        Field[] reflectionFields = reflectionClass.getDeclaredFields();

        Arrays.stream(reflectionFields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] allReflectionMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(allReflectionMethods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.printf("%s have to be public!%n", getter.getName()));

        Arrays.stream(allReflectionMethods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.printf("%s have to be private!%n", setter.getName()));


    }
}