package ex00;
import java.util.UUID;

enum Category {
    debit,
    credit
}
public class Transaction {

    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private Category TransferCategory;
    private int TransferAmount;

    public Transaction(User recipient, User sender, Category transferCategory, int transferAmount) {
        Identifier = UUID.randomUUID();
        Recipient = recipient;
        Sender = sender;
        TransferCategory = transferCategory;

        if (TransferCategory == Category.debit && transferAmount < 0) {
            System.out.println("Debit (incoming transaction) can't be negative, set to 0 by default");
            TransferAmount = 0;
        } else if (TransferCategory == Category.credit && transferAmount > 0) {
            System.out.println("Credit (outgoing transaction) can't be positive, set 0 by default");
            TransferAmount = 0;
        } else
            TransferAmount = transferAmount;
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(UUID identifier) {
        Identifier = identifier;
    }

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public Category getTransferCategory() {
        return TransferCategory;
    }

    public void setTransferCategory(Category transferCategory) {
        TransferCategory = transferCategory;
    }

    public int getTransferAmount() {
        return TransferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        if (TransferCategory == Category.debit && transferAmount < 0) {
            System.out.println("Debit (incoming transaction) can't be negative, set to 0 by default");
            TransferAmount = 0;
        } else if (TransferCategory == Category.credit && transferAmount > 0) {
            System.out.println("Credit (outgoing transaction) can't be positive, set 0 by default");
            TransferAmount = 0;
        } else
            TransferAmount = transferAmount;
    }
}
