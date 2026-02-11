import java.util.*;
@FunctionalInterface
interface Inter {
    int add(int a);   // Single abstract method

    default void show() {
        System.out.println("Hello!");
    }

    static int mul(int a, int b) {
        return a * b;
    }
}

public class FunctionalInterfaceJava9 {
    public static void main(String[] args) {

        // Using custom functional interface
        Inter i = (a) -> a + 10;   // implementation of add(int a)

        int result = i.add(5);
        System.out.println("Result from add: " + result); // 15

        i.show(); // default method

        int m = Inter.mul(3, 4); // static method
        System.out.println("Multiplication: " + m); // 12
    }
}
