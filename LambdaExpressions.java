import java.util.*;
import java.util.stream.Collectors;
@FunctionalInterface
interface A{
    int show(int a);
}
public class Main
{
	public static void main(String[] args) {
        A a1=(a)->a*a;
        System.out.println(a1.show(2));
	}
}
