package ex01;

public class Program {
        public static void main(String args[]) {
            User UserA = new User("A", 100 );
            User UserB = new User("B", 50);

            System.out.println(UserA.getIdentifier());
            System.out.println(UserB.getIdentifier());
            System.out.println(UserIdsGenerator.getInstance());
            User UserC = new User("C", 50);
            System.out.println(UserC.getIdentifier());
            System.out.println(UserIdsGenerator.getInstance());

        }
    }


