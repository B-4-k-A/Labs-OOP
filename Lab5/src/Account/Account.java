package Account;

import java.util.UUID;

public abstract class Account{
    public String id;
    public double balance;

    public Account(double balance) {
        this.id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public abstract void clearPercent();

    public abstract boolean canPay(double value);

    public abstract void calcPercent();

    public abstract double payPercent();




}
