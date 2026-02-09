import java.util.*;
import java.util.stream.Collectors;
public class StreamAPI
{
	public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(10);
        list.add(20);
        list.stream().map(n->n*2).forEach(System.out::println);
        list.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(list);
        list.stream().filter(n->n%2==0).forEach(System.out::println);
        int sum=list.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);
}
}
