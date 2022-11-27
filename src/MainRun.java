import account.Account;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<Account> accounts = new ArrayList<>();
        Account account1 = new Account("hai1", "123","hai123@gmail.com");
//        Account account2 = new Account("hai2", "456","hai456@gmail.com");
//        Account account3 = new Account("hai3", "789","hai789@gmail.com");
        accounts.add(account1);
//        accounts.add(account2);
//        accounts.add(account3);

        Scanner scanner = new Scanner(System.in);
        menu.displayMenu();
        menu.functionchoice(scanner,accounts, account1);
    }

}
