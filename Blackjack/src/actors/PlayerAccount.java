package actors;

public class PlayerAccount {

	double balance;
	public PlayerAccount(double balance){
		this.balance=balance;
	}
	public void deposit(double amount){
		balance+=amount;
	}
	public void withdrawl(double amount){
		balance-=amount;
	}
	public double getBalance(){
		return balance;
	}
}
