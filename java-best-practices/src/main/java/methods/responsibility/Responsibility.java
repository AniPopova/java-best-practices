package methods.responsibility;

import java.math.BigDecimal;
import java.util.UUID;

public class Responsibility {
    /**
     * One method should do one of the following two tings:
     * (CQS) Command-query separation
     * 1. Command: modify the state of an object and return nothing (void);
     * 2. Query: perform computation and return its result;
     * 3. the method should avoid any undocumented side effects
     */

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();

    }

    private static void showBadPractice() {
        BadCustomerAccount account = new BadCustomerAccount(UUID.randomUUID().toString(), BigDecimal.valueOf(100.0));
        account.processTransaction("withdraw", BigDecimal.valueOf(10.0));
        account.processTransaction("deposit", BigDecimal.valueOf(50.0));
    }

    private static void showGoodPractice() {
        GoodCustomerAccount account = new GoodCustomerAccount(UUID.randomUUID().toString(), BigDecimal.valueOf(100.0));
        account.showAmount();
        account.withdraw(BigDecimal.valueOf(10.0));
        account.showAmount();
        account.deposit(BigDecimal.valueOf(50.0));
        account.showAmount();
    }

}
