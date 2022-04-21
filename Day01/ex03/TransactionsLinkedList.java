package ex03;

//
//public class TransactionsLinkedList implements TransactionsList {
//
//    private MyLinkedList head;
//    private MyLinkedList tail;
//    private int size;
//
//    public TransactionsLinkedList() {
//        this.head = null;
//        this.tail = null;
//        size = 0;
//    }
//
//    @Override
//    public void addTransaction(Transaction transaction) {
//
//        MyLinkedList node = new MyLinkedList(transaction);
//        if (head == null) {
//            head = node;
//            tail = node;
//        }
//        else {
//            tail.next = node;
//            node.prev = tail;
//            tail = node;
//        }
//        ++size;
//
//    }
//
//    @Override
//    public void removeTransaction(UUID identifier) throws TransactionNotFoundException {
//        if (head != null) {
//            MyLinkedList tmp = head;
//            if (tmp.isFind(identifier)) {
//                if (tmp.next == null) {
//                    tmp.removeMylinkedList(head);
//                    head = null;
//                    --size;
//                    return;
//                }
//                tmp.removeMylinkedList(null);
//                head = tmp.next;
//                --size;
//                return;
//            }
//            while (tmp.next != null) {
//                MyLinkedList prev = tmp;
//                tmp = tmp.next;
//                if (tmp.isFind(identifier)) {
//                    tmp.removeMylinkedList(prev);
//                    --size;
//                    return;
//                }
//            }
//
//        }
//        throw new TransactionNotFoundException();
//    }
//    @Override
//    public Transaction[] toArray() {
//        Transaction transactionArr[] = new Transaction[size];
//        int i = 0;
//        if (head != null) {
//            transactionArr[0] = head.transaction;
//            MyLinkedList tmp = head.next;
//            while (tmp != null) {
//                transactionArr[++i] = tmp.transaction;
//                if (head.next != null) {
//                    tmp = tmp.next;
//                }
//            }
//        }
//        return transactionArr;
//    }
//
//    private class MyLinkedList {
//        Transaction transaction;
//        MyLinkedList next;
//        MyLinkedList prev;
//        MyLinkedList(Transaction transaction)
//        {
//            this.transaction = transaction;
//            this.next = null;
//            this.prev = null;
//        }
//
//        boolean isFind(UUID id){
//            return (transaction.getIdentifier().equals(id));
//        }
//
//        void removeMylinkedList(MyLinkedList prev) {
//            if (prev != null && prev.next != null) {
//                prev.next = next;
//            }
//            transaction = null;
//        }
//
////        public void printTransactionList()
////        {
//
////        }
//
//    }
//}
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private ListElement head;
    private ListElement tail;
    private Integer size;

    public TransactionsLinkedList() {
        size = 0;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        ListElement add = new ListElement();
        add.transaction = transaction;
        if (head == null){
            head = add;
            tail = add;
            add.next = null;
            add.prev = null;
        }
        else {
            tail.next = add;
            add.prev = tail;
            tail = add;
        }
        size++;
    }

    @Override
    public boolean removeTransaction(UUID id) throws TransactionNotFoundException {
        if (head == null)
            return false;
        if (head == tail){
            head = null;
            tail = null;
            size--;
            return true;
        }
        if (head.transaction.getIdentifier() == id){
            head.next.prev = null;
            head = head.next;
            size--;
            return  true;
        }
        ListElement temp = head;
        while (temp.next != null) {
            if (temp.next.transaction.getIdentifier() == id){
                if (tail == temp.next){
                    tail = temp;
                }
                else {
                    temp.next.next.prev = temp;
                    temp.next = temp.next.next;
                }
                size--;
                return true;
            }
            temp = temp.next;
        }
        throw new TransactionNotFoundException("Transaction not found");
    }

    @Override
    public Transaction[] toArray() {
        if (size == 0)
            return null;
        Transaction[] array = new Transaction[size];
        ListElement temp = head;
        Integer i = 0;
        while (i != size)
        {
            array[i] = temp.transaction;
            temp = temp.next;
            i++;
        }
        return array;
    }

    class ListElement {
        ListElement next;
        ListElement prev;
        Transaction transaction;
    }



}