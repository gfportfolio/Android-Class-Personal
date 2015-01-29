package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class CheckingAccount extends Account {
    private double availableBalance;


    public CheckingAccount(String name, String bank, String type, double currentBalance, boolean positive, double availableBalance) {
        super(name, bank, type, currentBalance, positive);
        this.availableBalance = availableBalance;
    }

    public CheckingAccount(String name, String type, double currentBalance, boolean positive, double availableBalance) {
        super(name, type, currentBalance, positive);
        this.availableBalance = availableBalance;
    }

    public CheckingAccount(String name, String type, double currentBalance, double availableBalance) {
        super(name, type, currentBalance);
        this.availableBalance = availableBalance;
    }

    public CheckingAccount(String name, double availableBalance) {
        super(name);
        this.availableBalance = availableBalance;
    }

    public CheckingAccount(String name, String bank, String type, double currentBalance, boolean positive) {
        super(name, bank, type, currentBalance, positive);
        this.availableBalance =0.0;
    }

    public CheckingAccount(String name, String type, double currentBalance, boolean positive) {
        super(name, type, currentBalance, positive);
        this.availableBalance =0.0;
    }

    public CheckingAccount(String name, String type, double currentBalance) {
        super(name, type, currentBalance);
        this.availableBalance =0.0;
    }

    public CheckingAccount(String name) {
        super(name);
        this.availableBalance =0.0;
    }

    public double getAvailableBalance() {
        return availableBalance;

    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

}
