package main.repository;

import main.exceptions.InsufficientBalance;
import main.models.Account;

public class AccountRepository {

    private final Account account;

    public AccountRepository(Account account) {
        this.account = account;
    }

    public void depositMoney(double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public void withdrawMoney (double amount) {
        double balance = account.getBalance();

        if (balance < amount) {
            throw new InsufficientBalance("Insufficient Balance");
        }

        account.setBalance(account.getBalance() - amount);
    }

    public double checkBalance () {
        return account.getBalance();
    }

    public int getCardPin(double number) {
        return account.getCard().getPin();
    }
}

