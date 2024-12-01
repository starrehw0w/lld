package main.services;

import main.exceptions.InsufficientCash;
import main.repository.ATMRepository;
import main.repository.AccountRepository;

public class ATMService {

    AccountRepository accountRepository;
    ATMRepository atmRepository;

    public ATMService (AccountRepository accountRepository, ATMRepository atmRepository) {
        this.accountRepository = accountRepository;
        this.atmRepository = atmRepository;
    }

    public boolean authenticate (double number, int pin) {
        int cardPin = accountRepository.getCardPin(number);
        return cardPin == pin;
    }

    public void depositMoney (double amount) {
        accountRepository.depositMoney(amount);
    }

    public void withdrawMoney (double amount) {
        double availableCash = atmRepository.getAvailableCash();

        if (availableCash < amount) {
            throw new InsufficientCash("Insufficient Cash. Try Again Later.");
        }

        accountRepository.withdrawMoney(amount);
    }

    public double checkBalance () {
        return accountRepository.checkBalance();
    }
}
