package data.types;

import java.math.BigDecimal;

public class Account {
    public static void main(String[] args) {

            Account account = new Account();
            account.deposit(BigDecimal.valueOf(150));
            account.withdraw(BigDecimal.valueOf(32,18));
            System.out.println(account.getBalanceString());

    }
    public BigDecimal balance = BigDecimal.ZERO;

    public Account() {
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);

    }

    public String getBalanceString() {
        return balance.toString();
    }
}


