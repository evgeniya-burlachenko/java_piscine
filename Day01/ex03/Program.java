import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User UserA = new User("A", 1000);
        User UserB = new User("B", 2000);
        User UserC = new User("C", 500);
		System.out.println("\n******************************* Balance *********************************\n");
        System.out.println("Balance start " +  UserA.getName()+ " :" + UserA.getBalance() +";");
		System.out.println("Balance start" +  UserB.getName()+ " :" + UserB.getBalance() +";");
		System.out.println("Balance start" +  UserC.getName()+ " :" + UserC.getBalance() +";");
        Transaction a1 = new Transaction(UserA, UserB, Category.debit,200);
        Transaction a2 = new Transaction(UserC, UserB, Category.credit,-300);
        Transaction a3 = new Transaction(UserB, UserA, Category.debit,300);
        Transaction a4 = new Transaction(UserC, UserA, Category.debit,200);
        Transaction a5 = new Transaction(UserC, UserB, Category.debit,400);
        Transaction[] ArrA = UserA.getTransactionsList().toArray();
        Transaction[] ArrB = UserB.getTransactionsList().toArray();
        Transaction[] ArrC = UserC.getTransactionsList().toArray();
		System.out.println("\n******************************* Balance *********************************\n");
        System.out.println("Balance " +  UserA.getName()+ " :" + UserA.getBalance() +";");
		System.out.println("Balance " +  UserB.getName()+ " :" + UserB.getBalance() +";");
		System.out.println("Balance " +  UserC.getName()+ " :" + UserC.getBalance() +";");
		System.out.println("\n***************************** Transactions UserA ************************\n");
        printTransactions(ArrA);
        System.out.println("\n***************************** Transactions UserB ************************\n");
        printTransactions(ArrB);
        System.out.println("\n***************************** Transactions UserC ************************\n");
        printTransactions(ArrC);
        try {
            UserC.getTransactionsList().removeTransaction(ArrC[1].getIdentifier());
			UserC.getTransactionsList().removeTransaction(ArrC[2].getIdentifier());
        }
        catch (TransactionNotFoundException ex) {
            ex.printStackTrace();
        }
        ArrC = UserC.getTransactionsList().toArray();
        System.out.println("\n************************** Remove transaction UserC *********************\n");
        printTransactions(ArrC);
    }

    public static void printTransactions(Transaction[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("UUID: " + arr[i].getIdentifier() + ", ");
            System.out.println("Recipient: " +  arr[i].getRecipient().getName() + ", Sender: " + arr[i].getSender().getName());
    
        }
    }
}
