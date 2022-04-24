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
            System.out.println("Error: Debit can't be negative. Set to 0 by default");
            TransferAmount = 0;
        } else if (TransferCategory == Category.credit && transferAmount > 0) {
            System.out.println("Error: Credit can't be positive. Set 0 by default");
            TransferAmount = 0;
        }
        if (sender.getBalance() > transferAmount) {
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }
        recipient.getTransactionsList().addTransaction(this);
        sender.getTransactionsList().addTransaction(this);
        this.TransferAmount = transferAmount;
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
}
