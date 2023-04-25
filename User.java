import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<User> userList = new ArrayList<>();
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public static List<User> getUserList() {
        return userList;
    }

    static {
        // Hard-code 10 users with IDs from 1 to 10 and different names
        userList.add(new User("1", "Alice"));
        userList.add(new User("2", "Bob"));
        userList.add(new User("3", "Charlie"));
        userList.add(new User("4", "David"));
        userList.add(new User("5", "Eve"));
        userList.add(new User("6", "Frank"));
        userList.add(new User("7", "Grace"));
        userList.add(new User("8", "Henry"));
        userList.add(new User("9", "Ivy"));
        userList.add(new User("10", "John"));
    }
}
