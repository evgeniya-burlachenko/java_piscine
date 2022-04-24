public class Program {
    public static void main(String[] args) {
        try {
            User UserA = new User("A", 100);
            User UserB = new User("B", 200);
            User UserC = new User("C", 300);
            User UserD = new User("D", 100);
            User UserE = new User("A", 100);
            User UserF = new User("B", 200);
            User UserG = new User("C", 300);
            User UserH = new User("D", 100);
            User UserI = new User("A", 100);
            User UserK = new User("B", 200);
            User UserL = new User("C", 300);
            User UserM = new User("D", 100);
            UsersArrayList ArrayList = new UsersArrayList();
            System.out.println("Retrieve Number start : " + ArrayList.RetrieveNumberOfUsers());
            System.out.println("Array size: " + ArrayList.getArraySize());
            ArrayList.addUser(UserA);
            ArrayList.addUser(UserB);
            ArrayList.addUser(UserC);
            ArrayList.addUser(UserD);
            ArrayList.addUser(UserE);
            ArrayList.addUser(UserF);
            ArrayList.addUser(UserG);
            ArrayList.addUser(UserH);
            ArrayList.addUser(UserI);
            ArrayList.addUser(UserK);
            ArrayList.addUser(UserL);
            ArrayList.addUser(UserM);
            System.out.println("Array size new :" + ArrayList.getArraySize());
            System.out.println("Retrieve Number : " + ArrayList.RetrieveNumberOfUsers());
            System.out.println("Retrieve by ID, UserA: " + ArrayList.RetrieveUserById(0).getIdentifier() + "; index = " + ArrayList.RetrieveUserByIndex(0));
            System.out.println("Retrieve by ID, UserB: " + ArrayList.RetrieveUserById(1).getIdentifier()+ "; index = " + ArrayList.RetrieveUserByIndex(1));
            System.out.println("Retrieve by index, UserA : " + ArrayList.RetrieveUserByIndex(0).getName()+ ", id = "+ ArrayList.RetrieveUserById(0).getIdentifier() );
            System.out.println("Retrieve by index, UserB : " + ArrayList.RetrieveUserByIndex(1).getName() + ", id = "+ ArrayList.RetrieveUserById(1).getIdentifier());
            System.out.println("Retrieve by index, UserC : " + ArrayList.RetrieveUserByIndex(2).getName() + ", id = "+ ArrayList.RetrieveUserById(2).getIdentifier());
           	System.out.println("Retrieve by ID ( not found) : " + ArrayList.RetrieveUserById(100));
        } catch (UserNotFoundException e) {
           System.out.println("ID or index not found!");
        }
    }
}

