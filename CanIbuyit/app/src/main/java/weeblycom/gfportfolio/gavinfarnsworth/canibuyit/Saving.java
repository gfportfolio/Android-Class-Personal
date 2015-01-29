package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Saving extends Account {
    public double availableBalance;
    public double interest;

    public Saving(String name, String bank, String type, double currentBalance, boolean positive, double availableBalance, double interest) {
        super(name, bank, type, currentBalance, positive);
        this.availableBalance = availableBalance;
        this.interest = interest;
    }

    public Saving(String name, String type, double currentBalance, boolean positive, double availableBalance, double interest) {
        super(name, type, currentBalance, positive);
        this.availableBalance = availableBalance;
        this.interest = interest;
    }

    public Saving(String name, String type, double currentBalance, double availableBalance, double interest) {
        super(name, type, currentBalance);
        this.availableBalance = availableBalance;
        this.interest = interest;
    }

    public Saving(String name, double availableBalance, double interest) {
        super(name);
        this.availableBalance = availableBalance;
        this.interest = interest;

    }

    public Saving(String name, String bank, String type, double currentBalance, boolean positive) {
        super(name, bank, type, currentBalance, positive);
        this.availableBalance =0.0;
        this.interest =1.0;
    }

    public Saving(String name, String type, double currentBalance, boolean positive) {
        super(name, type, currentBalance, positive);
        this.availableBalance =0.0;
        this.interest =1.0;
    }

    public Saving(String name, String type, double currentBalance) {
        super(name, type, currentBalance);
        this.availableBalance =0.0;
        this.interest =1.0;
    }

    public Saving(String name) {
        super(name);
        this.availableBalance =0.0;
        this.interest =1.0;
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
