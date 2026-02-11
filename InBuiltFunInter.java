import java.util.*;
import java.util.function.*;
public class InBuiltFunInter{
   public static void main(String args[]){
       // 1. Predicate<T>  -> takes T, returns boolean
       Predicate<Integer> isEven = (n) -> n % 2 == 0;
       System.out.println("Predicate (isEven) on 10: " + isEven.test(10)); // true
       System.out.println("Predicate (isEven) on 7: " + isEven.test(7));   // false

       // 2. Function<T, R> -> takes T, returns R
       Function<Integer, String> intToString = (n) -> "Number is: " + n;
       System.out.println("Function result: " + intToString.apply(5));

       // 3. Consumer<T> -> takes T, returns nothing (void)
       Consumer<String> printer = (s) -> System.out.println("Consumer prints: " + s);
       printer.accept("Hello Java");

       // 4. Supplier<T> -> takes nothing, returns T
       Supplier<Double> randomValue = () -> Math.random();
       System.out.println("Supplier gives: " + randomValue.get());

       // 5. BiFunction<T, U, R> -> takes T and U, returns R
       BiFunction<Integer, Integer, Integer> addTwo = (a, b) -> a + b;
       System.out.println("BiFunction (addTwo) result: " + addTwo.apply(10, 20));
   }
 }