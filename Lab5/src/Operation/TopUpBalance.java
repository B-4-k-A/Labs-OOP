package Operation;

import Account.Account;

import java.util.Calendar;

public class TopUpBalance extends Operation{
    protected double sum;

    public TopUpBalance(Account account, Calendar date, double sum) {
        super(account, date);
        this.sum = sum;
    }

    @Override
    public void doOperation() {
        owner.balance += sum;
    }

    @Override
    public void undoOperation() {
        owner.balance -= sum;
    }
}
