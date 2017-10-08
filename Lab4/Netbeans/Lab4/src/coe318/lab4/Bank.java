/**
 *
 * @author Gabriel Casciano, 500744076
 */
package coe318.lab4;

public class Bank {
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    private Account [] accounts;
    private int numAccounts;//number of active accounts

    /**
     *
     * @param name The name of the bank
     * @param maxNumberAccounts The maximum number of accounts that the bank can open
     */
    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
        for(int i = 0; i<maxNumberAccounts; i++)//intializes all of the accounts such that it does not the JVM does not throw a NullException error.
            accounts[i] = new Account("", 0, 0);
    }

    /**
     *
     * @param bank Bank to be used to create a new Bank
     */
    public Bank(Bank bank){
        name = bank.getName();
        accounts = bank.getAccounts();
        numAccounts = bank.getNumAccounts();
    }
    /**
     * @return the name
     */
    public String getName() { return name; }

    /**
     * @return the numAccounts
     */
    public int getNumAccounts() { return numAccounts; }

    /**
     *
     * @return the array of accounts associated with this bank
     */
    public Account[] getAccounts() { return accounts; }

    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber the Number to be searched for
     * @return a boolean based on whether or not the bank already has the number
     */
    public boolean hasAccountNumber(int accountNumber) {
        for(Account account : accounts) {
                if (account.getNumber() == accountNumber)
                    return true;
        }
        return false;
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account the account to be added
     * @return true if successful
     */
    public boolean add(Account account) {
        if(numAccounts != accounts.length && !hasAccountNumber(account.getNumber())){
            accounts[numAccounts] = new Account(account);
            numAccounts++;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}