package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class SavingsAccount extends Account {
    public double availableBalance;
    public double interest;

    public SavingsAccount(String name, String bank, double currentBalance,  double availableBalance, double interest, int id) {
        super(name, bank, "Savings Account", currentBalance, true, id);
        this.availableBalance = availableBalance;
        this.interest = interest;

    }

    @Override
    void sum() {

    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
