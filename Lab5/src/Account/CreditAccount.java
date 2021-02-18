package Account;

public class CreditAccount extends Account{

    private double limit;
    private final double percent;
    private double commission;

    public CreditAccount(double balance, double limit, double percent) {
        super(balance);
        this.limit = limit;
        this.percent = percent;
    }

    @Override
    public void clearPercent() {
        commission = 0;
    }

    @Override
    public boolean canPay(double value) {
        if(balance - value < 0) {
            return Math.abs(balance - value) < limit;
        }
        return true;
    }

    @Override
    public void calcPercent() {
        if(balance < 0) {
            commission = balance * percent / 100;
        }
    }

    @Override
    public double payPercent() {
        return commission;
    }

}
