package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class SavingsAccount extends Account {
    public double availableBalance;
    public double interest;

    public SavingsAccount(String name, String bank, double currentBalance, boolean positive, double availableBalance, double interest) {
        super(name, bank, "Savings Account", currentBalance, positive);
        this.availableBalance = availableBalance;
        this.interest = interest;

    }

    public SavingsAccount(String name, double currentBalance, boolean positive, double availableBalance, double interest) {
        super(name, "Savings Account", currentBalance, positive);
        this.availableBalance = availableBalance;
        this.interest = interest;
    }

    public SavingsAccount(String name, double currentBalance, double availableBalance, double interest) {
        super(name, "Savings Account", currentBalance);
        this.availableBalance = availableBalance;
        this.interest = interest;
    }

    public SavingsAccount(String name, double availableBalance, double interest) {
        super(name);
        super.setType("Savings Account");
        this.availableBalance = availableBalance;
        this.interest = interest;

    }

    public SavingsAccount(String name, String bank,  double currentBalance, boolean positive) {
        super(name, bank, "Savings Account", currentBalance, positive);
        this.availableBalance =0.0;
        this.interest =1.0;
    }

    public SavingsAccount(String name, double currentBalance, boolean positive) {
        super(name, "Savings Account", currentBalance, positive);
        this.availableBalance =0.0;
        this.interest =1.0;
    }

    public SavingsAccount(String name, double currentBalance) {
        super(name, "SavingsAccount", currentBalance);
        this.availableBalance =0.0;
        this.interest =1.0;
    }

    public SavingsAccount(String s, String bank, String name, double currentBalance, boolean positive, double availableBalance, double interest) {
        super(name);
        this.availableBalance =0.0;
        this.interest =1.0;
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
