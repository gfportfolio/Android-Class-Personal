package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class CheckingAccount extends Account {
    private double availableBalance;


    public CheckingAccount(String name, String bank, double currentBalance, boolean positive, double availableBalance, int id) {
        super(name, bank, "Checking Account", currentBalance, positive, id);
        this.availableBalance = availableBalance;
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

}
