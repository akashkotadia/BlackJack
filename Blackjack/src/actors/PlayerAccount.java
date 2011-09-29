package actors;

public class PlayerAccount {

	double balance;
	public PlayerAccount(double balance){
		this.balance=balance;
	}
	public void deposit(double amount){
		balance+=amount;
		System.out.println("Added : " + amount + "Balance : "+balance);
	}
	public void withdrawl(double amount){
		balance-=amount;
		System.out.println("Subtract : " + amount + "Balance :" + balance);
	}
	public double getBalance(){
		return balance;
	}
}
