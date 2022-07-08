package bankAccount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class App_1 {

    class BankAccount{
        public int balance = 0;
        public void deposit(int amount){
            // balance = balance + amount;
        }
    }

    @Test
    public void test(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(50);
        assertEquals(50, bankAccount.balance);
    }
}
