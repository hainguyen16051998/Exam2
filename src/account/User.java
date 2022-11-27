package account;

import java.util.ArrayList;

public class User {
    private ArrayList<Account> accounts;

    public User(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "accounts=" + accounts +
                '}';
    }
}
