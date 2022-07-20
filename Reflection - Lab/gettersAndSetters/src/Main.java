import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflectionClass = Reflection.class;

        Method[] allReflectionMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(allReflectionMethods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType().getName()));
        Arrays.stream(allReflectionMethods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.printf("%s and will set field of class %s%n", setter.getName(), setter.getParameterTypes()[0].getName()));

    }
}