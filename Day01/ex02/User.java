public class User {
    private final int Identifier;
    private String Name;
    private int Balance;

    public User(String name, int balance) {
        Identifier = UserIdsGenerator.getInstance().generateId();
        Name = name;
        if (balance < 0) {
            System.out.println("error: balance cannot be negative. Set to 0 by default.");
            Balance = 0;
        } else
            Balance = balance;
    }

    public int getIdentifier() {
        return Identifier;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            System.out.println("Error: balance cannot be negative. Set to 0 by default.");
            Balance = 0;
        } else
            Balance = balance;
    }

    public void printUser() {
        System.out.println(Name + " [Identifier: " + Identifier + ", Name: " + Name + ", Balance: " + Balance + "]" + "\n");
    }
}
