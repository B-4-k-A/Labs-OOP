package Operation;

import Account.Account;

import java.util.Calendar;

public class Transaction extends Operation{
    protected Account receiver;
    protected double sum;

    public Transaction(Account owner, Account receiver, Calendar date, double sum) {
        super(owner, date);
        this.receiver = receiver;
        this.sum = sum;

    }

    @Override
    public void doOperation() {
        owner.balance -= sum;
        receiver.balance += sum;
    }

    @Override
    public void undoOperation() {
        owner.balance += sum;
        receiver.balance -= sum;
    }
}
