package main.repository;

import main.models.ATM;

public class ATMRepository {

    private ATM atm;

    public ATMRepository (ATM atm) {
        this.atm = atm;
    }

    public double getAvailableCash () {
        return atm.getAvailableCash();
    }
}
