package Account;

public class DebitAccount extends Account{

    private final double percent;

    private double bonus;

    public DebitAccount(double balance, double percent) {
        super(balance);
        this.percent = percent;
    }

    @Override
    public void clearPercent() {
        this.bonus = 0;
    }

    @Override
    public boolean canPay(double value) {
        return this.balance >= value;
    }

    @Override
    public void calcPercent() {
        bonus += balance * percent / 365 / 100;
    }

    @Override
    public double payPercent() {
        return bonus;
    }
}
