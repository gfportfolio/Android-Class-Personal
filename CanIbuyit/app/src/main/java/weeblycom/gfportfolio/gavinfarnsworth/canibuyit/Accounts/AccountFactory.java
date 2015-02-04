package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 2/3/15.
 */
public class AccountFactory {
    private String type;
    private String name;
    private String bank;
    private double currentBalance;
    private boolean positive;
    private double owedBalance;
    private double interest;
    private Date dueDate;
    private double paymentAmount;
    private double availableBalance;
    private double limit;
    private int id;

    public AccountFactory(String type, String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance, double limit, int id) {
        this.type = type;
        this.name = name;
        this.bank = bank;
        this.currentBalance = currentBalance;
        this.positive = positive;
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
        this.availableBalance = availableBalance;
        this.limit = limit;
        this.id = id;
    }

    public Account makeAccount() {
        Account newAccount = null;
        switch (type) {
            case "CheckingAccount":
                newAccount=addCheckingAccount(name, bank, currentBalance, positive, availableBalance, id);
            case "CreditCard":
                newAccount=addCreditCard( name,  bank,  currentBalance, owedBalance,  interest,  dueDate,  paymentAmount,  availableBalance, limit, id);
            case "Loan":
                newAccount=addLoan( name,  bank, currentBalance, paymentAmount,  owedBalance,  interest,  dueDate, id);
            case "OtherAccount":
                newAccount=addOtherAccount( name,  bank,   currentBalance,  positive, id);
            case "Savings":
                newAccount=addSavingsAccount( name,  bank,  currentBalance, availableBalance,  interest, id);
        }
        return newAccount;
    }

    private SavingsAccount addSavingsAccount(String name, String bank,  double currentBalance, double availableBalance, double interest, int id) {
        SavingsAccount newAccount = new SavingsAccount(name,  bank,   currentBalance,  availableBalance,  interest, id);
        //String name, String bank, String type, double currentBalance, boolean positive, double availableBalance, double interest
        return newAccount;
    }

    private OtherAccount addOtherAccount(String name, String bank,  double currentBalance, boolean positive, int id) {
        OtherAccount newAccount = new OtherAccount(name,  bank,   currentBalance,  positive, id);
        // String name, String bank,  double currentBalance, boolean positive
        return newAccount;
    }

    private Loan addLoan(String name, String bank,  double currentBalance, double paymentAmount, double owedBalance, double interest, Date dueDate, int id) {
        Loan newAccount = new Loan(name,  bank, currentBalance, paymentAmount,  owedBalance,  interest,  dueDate, id);
        //String name, String bank,  double currentBalance, boolean positive, double paymentAmount, double owedBalance, double interest, Date dueDate
        return newAccount;
    }

    private CreditCard addCreditCard(String name, String bank, double currentBalance,  double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance, double limit, int id) {
        CreditCard newAccount = new CreditCard(name,  bank,  currentBalance,   owedBalance,  interest,  dueDate,  paymentAmount,  availableBalance, limit, id);
        // String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance
        return newAccount;
    }

    private CheckingAccount addCheckingAccount(String name, String bank, double currentBalance, boolean positive, double availableBalance, int id) {
        CheckingAccount newAccount = new CheckingAccount(name, bank, currentBalance, positive, availableBalance, id);
        //String name, String bank, double currentBalance, boolean positive, double availableBalance
        return newAccount;
    }





}
