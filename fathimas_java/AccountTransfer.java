import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;


public class AccountTransfer{
    long accountno;
    double balance;
    String [] payees = new String [3];
    long [] payeesaccount = new long [10];

    AccountTransfer(long accountno, double balance){

        this.accountno = accountno;
        this.balance = balance;
    }

    AccountTransfer(long accountno, double balance, String [] payees, long [] payeesaccount){

        this(accountno,balance);
        this.payees = payees;
        this.payeesaccount = payeesaccount;
    }

    public int debitAmount(double amount){
        
        if(amount<= balance)
            return 1;
        else
           return 0;
    }

    public int transferMoney(double amount, long payeesaccount){
        
        for ( int i = 0; i < this.payeesaccount.length; i++ ){

            if( this.payeesaccount[i] == payeesaccount )
                return debitAmount(amount);    
        }
        return -1;
    }

    public int transferMoney(double amount, String payees){
        
        for(int i = 0; i < this.payees.length; i++){
            if(this.payees[i].equalsIgnoreCase(payees))
            return debitAmount(amount);
        }
        return -1;
    }

    public static void main(String[] args) {
        String [] payees = new String[100];
        long [] payeesaccount = new long [10];
        
    // Mannualyy entering the values for payees
        payees[0] = "sbi";
        payees[1] = "sib";

    // Mannualyy entering the values for payeeaccounts
        payeesaccount[0] = 123456;
        payeesaccount[1] = 456789;

    // creating user account
        AccountTransfer obj = new AccountTransfer(11111,1000.025,payees,payeesaccount);
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Give ammount and payeeacoount number");
        double amount = sc.nextDouble();
        long payeeact = sc.nextLong();
        System.out.println(obj.transferMoney(amount,payeeact)); // account number transaction

        System.out.println("Give ammount and payee name");
        amount = sc.nextDouble();
        String name = sc.next();
        System.out.println(obj.transferMoney(amount,name)); // payee name transaction
    }
}