package Models;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {

    private long card;
    private static long oldCard;
    private int balance;

    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getCard() {
        return card;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}
