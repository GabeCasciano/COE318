/**
 * @author Gabriel Casciano, 500744076
 */
package coe318.lab4;

public class Account {

    private String Name;
    private double Balance;
    private int Number;

    /**
     *
     * @param Name name of the Account
     * @param Balance initial Balance
     * @param Number Account Number
     */
    public Account(String Name, int Number, double Balance){
        this.Name = Name;
        this.Balance = Balance;
        this.Number = Number;
    }

    /**
     *
     * @param account Account to be used to create a new account
     */
    public Account(Account account){
        Name = account.getName();
        Balance = account.getBalance();
        Number = account.getNumber();
    }
    /**
     *
     * @return Name of the Account
     */
    public String getName(){
        return Name;
    }
    /**
     *
     * @return the current Balance of the Account
     */
    public double getBalance(){
        return Balance;
    }
    /**
     *
     * @return the Account Number
     */
    public int getNumber(){
        return Number;
    }
    /**
     *
     * @param amount the Amount of money to be withdrawn from the Balance of the Account
     * @return successful withdraw
     */
    public boolean withdraw(double amount){
        if(amount >0 && amount < Balance){
           Balance -= amount;
           return true;
       }
       return false;
    }
    /**
     *
     * @param amount the Amount of money to be deposited into the Balance of the Account
     * @return successful deposit
     */
    public boolean deposit(double amount){
        if(amount > 0) {
            Balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " +
                String.format("$%.2f", getBalance()) + ")";
    }

}
