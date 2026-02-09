import java.util.Optional;

public class OptionalDemo {

    // Simple User class for real-world example
    static class User {
        String name;
        User(String name) {
            this.name = name;
        }
        String getName() {
            return name;
        }
    }

    // Method that may or may not return a User
    public static Optional<User> findUserById(int id) {
        if (id == 1) {
            return Optional.of(new User("Sujal"));
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {

        // 1. Creating Optional

        Optional<String> opt1 = Optional.of("Hello");      // must not be null
        Optional<String> opt2 = Optional.ofNullable(null); // safe with null
        Optional<String> opt3 = Optional.empty();          // empty optional

        System.out.println("opt1: " + opt1);
        System.out.println("opt2: " + opt2);
        System.out.println("opt3: " + opt3);

        // 2. isPresent() and get()

        if (opt1.isPresent()) {
            System.out.println("opt1 value: " + opt1.get());
        }

        // Better: ifPresent()
        opt1.ifPresent(v -> System.out.println("ifPresent: " + v));

        // 3. orElse() and orElseGet()

        String value1 = opt3.orElse("Default Value");
        System.out.println("orElse: " + value1);

        String value2 = opt3.orElseGet(() -> "Generated Default");
        System.out.println("orElseGet: " + value2);

        // 4. orElseThrow()

        try {
            String value3 = opt3.orElseThrow(() -> new RuntimeException("Value not found!"));
            System.out.println(value3);
        } catch (Exception e) {
            System.out.println("orElseThrow exception: " + e.getMessage());
        }

        // 5. map() - transform value

        Optional<String> name = Optional.of("sujal");
        Optional<String> upperName = name.map(n -> n.toUpperCase());
        System.out.println("map to upper: " + upperName.orElse("No name"));

        // 6. filter() - keep only if condition matches

        Optional<String> longName = name.filter(n -> n.length() > 3);
        System.out.println("filter (length > 3): " + longName.orElse("Too short"));

        Optional<String> shortName = name.filter(n -> n.length() > 10);
        System.out.println("filter (length > 10): " + shortName.orElse("Too short"));

        // 7. Real-world example: find user

        Optional<User> userOpt1 = findUserById(1);
        Optional<User> userOpt2 = findUserById(2);

        User user1 = userOpt1.orElse(new User("Guest"));
        User user2 = userOpt2.orElse(new User("Guest"));

        System.out.println("User1 name: " + user1.getName());
        System.out.println("User2 name: " + user2.getName());

        // 8. Chaining: map + orElse

        String userName1 = findUserById(1)
                .map(User::getName)
                .orElse("Unknown");

        String userName2 = findUserById(2)
                .map(User::getName)
                .orElse("Unknown");

        System.out.println("Chained userName1: " + userName1);
        System.out.println("Chained userName2: " + userName2);

        // 9. ifPresentOrElse (Java 9+ style)

        findUserById(1).ifPresentOrElse(
                u -> System.out.println("Found user: " + u.getName()),
                () -> System.out.println("User not found")
        );

        findUserById(2).ifPresentOrElse(
                u -> System.out.println("Found user: " + u.getName()),
                () -> System.out.println("User not found")
        );

        System.out.println("---- Demo Finished ----");
    }
}
