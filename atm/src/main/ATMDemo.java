package main;

import main.controllers.ATMController;
import main.exceptions.AuthenticationException;
import main.exceptions.OperationException;
import main.models.ATM;
import main.models.Account;
import main.models.Card;
import main.models.User;
import main.repository.ATMRepository;
import main.repository.AccountRepository;
import main.services.ATMService;

import java.util.Scanner;

public class ATMDemo {

    private Account setupAccount () {

        // user setup
        User user = new User();
        user.setName("first_last");
        user.setEmail("first_last@mail.com");

        // card setup
        Card card = new Card();
        card.setNumber(12345);
        card.setPin(1234);
        card.setCvv(123);

        // account setup
        Account account = new Account();
        account.setAccountNumber(123456789);
        account.setBalance(100000);
        account.setCard(card);
        account.setUser(user);

        return account;
    }

    private ATM setupAtm () {

        // atm setup
        ATM atm = new ATM();
        atm.setAvailableCash(150000);
        return atm;
    }

    private void run(ATMController atmController) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Card Number");
        double number = scanner.nextDouble();

        System.out.println("Enter Card Pin");
        int pin = scanner.nextInt();

        if (!atmController.authenticate(number, pin)) {
            throw new AuthenticationException("Authentication Failed");
        }

        while (true) {

            System.out.println(
                "Choose Your Option : " +
                "1. Deposit Cash " +
                "2. Withdraw Cash " +
                "3. Check Balance " +
                "4. Exit"
            );

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Deposit Amount");
                    double depositAmount = scanner.nextDouble();

                    atmController.depositMoney(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter Withdraw Amount");
                    double withdrawAmount = scanner.nextDouble();

                    atmController.withdrawMoney(withdrawAmount);
                    break;

                case 3:
                    double balance = atmController.checkBalance();
                    System.out.println("Current Balance : " + balance);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Option. Try Again.");
            }
        }
    }

    public static void main (String[] args) {

        ATMDemo atmDemo = new ATMDemo();

        ATM atm = atmDemo.setupAtm();
        ATMRepository atmRepository = new ATMRepository(atm);

        Account account = atmDemo.setupAccount();
        AccountRepository accountRepository = new AccountRepository(account);

        ATMService atmService = new ATMService(accountRepository, atmRepository);
        ATMController atmController = new ATMController(atmService);

        atmDemo.run(atmController);
    }
}
