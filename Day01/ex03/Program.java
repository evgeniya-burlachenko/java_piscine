package ex03;

import java.util.UUID;
//
//public class Program {
//    public static final String GREEN = "\u001B[32m";
//    public static final String RESET = "\u001B[0m";
//
//    public static void main(String args[]) throws UserNotFoundException {
//        UsersArrayList userList = new UsersArrayList();
//
//        for (int i = 0; i < 30; ++i) {
//            userList.addUser(new User(String.valueOf(i), i));
//        }
//        System.out.println("Array users size: " + userList.getArraySize());
//
//        User UserA = new User("A", 10000);
//        User UserB = new User( "B", 5000);
//
//        System.out.println(GREEN +"new User: " + RESET);
//        System.out.println("User: " + UserA.getName() + "; id: " + UserA.getId()
//                + "; balance: " + UserA.getBalance());
//        System.out.println("User: " + UserB.getName() + "; id: " + UserB.getId()
//                + "; balance: " + UserB.getBalance());
//
//
//        System.out.println(GREEN + "Add transactionList:" + RESET);
//        Transaction creditTransaction = new Transaction(UserB, UserA, Category.credit, -500);
//
//
//        UserA.getTransactionsList().addTransaction(creditTransaction);
//        UserB.setBalance(UserB.getBalance() - creditTransaction.getTransferAmount());
//        UserA.setBalance(UserA.getBalance() + creditTransaction.getTransferAmount());
//        System.out.println("transaction ID " + creditTransaction.getIdentifier());
//
//        creditTransaction = new Transaction(UserB, UserA, Category.credit, -100);
//        UserA.getTransactionsList().addTransaction(creditTransaction);
//        UserA.setBalance(UserA.getBalance() + creditTransaction.getTransferAmount());
//        UserB.setBalance(UserB.getBalance() - creditTransaction.getTransferAmount());
//        UUID delete1 = creditTransaction.getIdentifier();
//        System.out.println("transaction ID " + creditTransaction.getIdentifier());
//
//        creditTransaction = new Transaction(UserB, UserA, Category.credit, -400);
//        UserA.getTransactionsList().addTransaction(creditTransaction);
//        UserA.setBalance(UserA.getBalance() + creditTransaction.getTransferAmount());
//        UserB.setBalance(UserB.getBalance() - creditTransaction.getTransferAmount());
//        UUID delete2 = creditTransaction.getIdentifier();
//        System.out.println("transaction ID1 " + creditTransaction.getIdentifier());
//
//        Transaction transactionArrayUserA[] = UserA.getTransactionsList().toArray();
//        System.out.println(GREEN + "User A  transaction list after toArray:" + RESET);
//        for(int i = 0; i < transactionArrayUserA.length; ++i) {
//           transactionArrayUserA[i].printTransaction();
//           System.out.println(UserA.getId());
//        }
//
//        System.out.println(GREEN +"Remove TransactionList: " + RESET);
//
//       UserA.getTransactionsList().removeTransaction(delete1);
//        UserA.getTransactionsList().removeTransaction(delete2);
//
//        //System.out.println("User id: " + UserA.getTransactionsList());
//        System.out.println("balance A: " + UserA.getBalance());
//        System.out.println("balance B: " + UserB.getBalance());
//
//        System.out.println(GREEN + "User A  transaction list after toArray:" + RESET);
//        for(int i = 0; i < transactionArrayUserA.length; ++i) {
//            transactionArrayUserA[i].printTransaction();
//        }
//
//    }
//
//}

public class Program {

    public static void main(String[] args) {
        User a = new User("Lisa", 540);
        User b = new User("Roma", 270);
        User c = new User("Petya", 2000);

        Transaction one = new Transaction(a, b, Category.debit,120);
        Transaction two = new Transaction(c, b, Category.credit,-40);
        Transaction three = new Transaction(b, a, Category.debit,210);
        Transaction four = new Transaction(c, a, Category.debit,330);
        Transaction five = new Transaction(c, b, Category.debit,580);
        Transaction six = new Transaction(a, c, Category.debit,3324235);
        Transaction[] arrA = a.getTransactionsList().toArray();
        Transaction[] arrB = b.getTransactionsList().toArray();
        Transaction[] arrC = c.getTransactionsList().toArray();
        System.out.printf("%s - balance: %d\n", a.getName(), a.getBalance());
        System.out.printf("%s - balance: %d\n", b.getName(), b.getBalance());
        System.out.printf("%s - balance: %d\n", c.getName(), c.getBalance());
        System.out.println("list transactions of a User");
        printTransactions(arrA);
        System.out.println("list transactions of b User");
        printTransactions(arrB);
        System.out.println("list transactions of c User");
        printTransactions(arrC);
        try {
            b.getTransactionsList().removeTransaction(arrB[1].getIdentifier());
        }
        catch (TransactionNotFoundException ex) {
            ex.printStackTrace();
        }
        arrB = b.getTransactionsList().toArray();
        System.out.println("ALTERED b User");
        printTransactions(arrB);
    }

    public static void printTransactions(Transaction[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("UUID: " + arr[i].getIdentifier() + ", ");
            System.out.printf("recipient: %s, sender: %s",
                    arr[i].getRecipient().getName(),
                    arr[i].getSender().getName());
            System.out.println();
        }
    }
}
