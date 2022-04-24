public class Program {

    public static void main(String args[]) {
        User UserA = new User(1, "A", 100 );
        User UserB = new User(2, "B", -50);
        User UserC = new User(3,"C", 1000);

        UserB.setBalance(2000);
        UserC.setName("User1");
        UserC.setIdentifier(40);
        UserC.printUser();

        System.out.println("Balance "+ UserA.getName() + " :" + UserA.getBalance());
        System.out.println("Balance  " + UserB.getName() + " :" + UserB.getBalance() + "\n");

        Transaction transaction_debit = new Transaction(UserA, UserB, Category.debit,1000);
        Transaction transaction_credit = new Transaction(UserB, UserA, Category.credit,-50);
        System.out.println("transfer amount from UserB: " + transaction_debit.getTransferAmount());
        System.out.println("transfer amount to UserA: " + transaction_credit.getTransferAmount() +"\n");

        UserA.setBalance(UserA.getBalance() + transaction_debit.getTransferAmount());
        System.out.println("Balance A: "  + UserA.getBalance());
        UserB.setBalance(UserB.getBalance() + transaction_credit.getTransferAmount());
        System.out.println("Balance B: " + UserB.getBalance()  + "\n");

        System.out.println("Invalid transaction: ");
        Transaction invalid_debit = new Transaction(UserA, UserB, Category.debit,-1000);
        Transaction invalid_credit = new Transaction(UserB, UserA, Category.credit,50);
        System.out.println("\n" + "transfer amount: " + invalid_credit.getTransferAmount());
        System.out.println("transfer amount: " + invalid_debit.getTransferAmount());
    }
}
