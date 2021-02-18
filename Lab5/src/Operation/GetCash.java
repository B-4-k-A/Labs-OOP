package Operation;

import Account.Account;

import java.util.Calendar;

public class GetCash extends Operation{
    private double sum;

    public GetCash(Account account, Calendar date, double sum) {
        super(account, date);
        this.sum = sum;
    }

    @Override
    public void doOperation() {
        owner.balance -= sum;
    }

    @Override
    public void undoOperation() {
        owner.balance += sum;
    }
}
