package Account;

public class DepositAccount extends Account{

    public int period;
    private final double percent;
    private double bonus = 0;

    public DepositAccount(double balance, double percent,
                          int period) {
        super(balance);
        this.percent = percent;
        this.period = period;
    }

    @Override
    public void clearPercent() {
        bonus = 0;
    }

    @Override
    public boolean canPay(double value) {
        return balance >= value && period == 0;
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
