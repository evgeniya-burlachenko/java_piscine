package ex03;
public class UserIdsGenerator {
    private static int Identifier = 0;
    private static UserIdsGenerator instance;
    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public static int generateId()
    {
        return Identifier++;
    }
}
