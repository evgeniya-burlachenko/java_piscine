public class Program {
    public static void main(String[] args) {
            User UserA = new User("A", 100);
            User UserB = new User("B", 50);
            User UserC = new User("C", 200);
            User UserD = new User("D", 200);

			System.out.println(UserIdsGenerator.getInstance());
            System.out.println(UserA.getIdentifier());
            System.out.println(UserB.getIdentifier());
            System.out.println(UserC.getIdentifier());
            System.out.println(UserD.getIdentifier());
            System.out.println(UserIdsGenerator.getInstance());
    }
}
