import java.util.*;

public class Diamond {
    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<>() {
            @Override
            public boolean add(Integer b) {
                System.out.println("Adding: " + b);
                return super.add(b); // actually add to list
            }
        };

        a.add(1);
        a.add(2);

        System.out.println(a); // check contents
    }
}
