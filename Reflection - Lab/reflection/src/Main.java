import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class reflectionClass = Reflection.class;

        System.out.println(reflectionClass);

        System.out.println(reflectionClass.getSuperclass());

        Class[] reflectionInterfaces = reflectionClass.getInterfaces();
        for (Class reflectionInterface : reflectionInterfaces) {
            System.out.println(reflectionInterface);
        }

        Object reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}