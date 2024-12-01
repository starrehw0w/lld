package main.controllers;

import main.services.ATMService;

public class ATMController {

    ATMService atmService;

    public ATMController (ATMService atmService) {
        this.atmService = atmService;
    }

    public boolean authenticate (double number, int pin) {
        return atmService.authenticate(number, pin);
    }

    public void depositMoney(double amount) {
        atmService.depositMoney(amount);
    }

    public void withdrawMoney (double amount) {
        atmService.withdrawMoney(amount);
    }

    public double checkBalance () {
        return atmService.checkBalance();
    }
}
