import java.util.*;
import java.util.stream.Collectors;
public class Run
{
	public static void main(String[] args) {
        Runnable r=()->{
            int a=10,b=20,c=30;
            System.out.println(a+b+c);
        };
        r.run();
}
}
