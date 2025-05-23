package com.Constructor;

public class FixedDepositAccount {
	private String customerName;
	private double principalAmount;
	private double interestRate;
	private int duration;
	private double maturityAmount;
	
	public FixedDepositAccount(String customerName, double principalAmount, double interestRate, int duration, double maturityAmount) {
		this.customerName = customerName;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.duration = duration;
		this.maturityAmount = maturityAmount;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	
	public double getPrincipalAmount() {
		return principalAmount;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	
	public double getMaturityAmount(double maturityAmount) {
		return maturityAmount;
	}
	
	public double calculateMaturityAmount() {
		 
		double rate = this.interestRate / 100.0;
		double ci = this.principalAmount * Math.pow(1 + (rate / 12), 12 * this.duration);
		this.maturityAmount = ci;
		
		return Math.round(this.maturityAmount * 100.0) / 100.0;
		
	}
	
	
	public void withdrawBeforeMaturity(int withdrawInMonths) {
		 if (withdrawInMonths < 12) {
		        System.out.println("Cannot withdraw before one year");
		    } 
		 
		  else if(withdrawInMonths < this.duration * 12){
		        double penalty = this.principalAmount * 0.02; 
		        double withdrawAmount = this.principalAmount - penalty; 
		        System.out.println("Withdrawal before maturity with 2% penalty applied.");
		        System.out.println("Amount after penalty: " + Math.round(withdrawAmount * 100.0) / 100.0);
		    }
		  else {
			  System.out.println("You are withdrawing after maturity go and collect it");
		  }
}
	public static void main(String[] args) {
		FixedDepositAccount f = new FixedDepositAccount("Ameer", 500000, 8, 3, 0 );
		System.out.println(f.calculateMaturityAmount());
		f.withdrawBeforeMaturity(14);
	}
}
