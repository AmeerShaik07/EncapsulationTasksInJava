package com.Constructor;

public class LoanApplication {
	private String customerName;
	private double loanAmount;
	private double interestRate;
	private int loanTerm;
	private double outStandingBalance;
	
	public LoanApplication(String customerName, double loanAmount, double interestRate, int loanTerm, double outStandingBalance) {
		this.customerName = customerName;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.outStandingBalance = outStandingBalance;
		System.out.println("Loan Application Submited");
	}
	
	public String getCustonerName() {
		return customerName;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public int getLoanTerm() {
		return loanTerm;
	}
	
	public double getOutStandingBalance() {
		return outStandingBalance;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	
	public void setOutStandingBalance(double outStandingBalance) {
		this.outStandingBalance = outStandingBalance;
	}
	
	public void makePayment(double amount) {
		if(amount <= 0) {
			System.out.println("Invalid Payment Amount");
		}
		else if(amount > outStandingBalance && amount == 0) {
			System.out.println("Patment exceeds loan balance");
		}
		else {
			outStandingBalance -= amount;
		}
	}
	public double calculateEMI() {
		double monthlyRate = this.interestRate / (12 * 100);
		int Months = this.loanTerm * 12;
		if(monthlyRate == 0) {
			return this.loanAmount / Months;
		}
		
		double emi = (this.loanAmount * monthlyRate * Math.pow(1 + monthlyRate, Months)) /
                (Math.pow(1 + monthlyRate, Months) - 1);
		return Math.round(emi * 100.0)/100.0;
	}
	
	public void displayDetails() {
		System.out.println("Loan Details :" + "\nCustomer Name : " + customerName + "\nLoan Amount : " + loanAmount + "\nInterest Rate : " + interestRate + "\nLoan Term : " + loanTerm + "\nOut Standing balance : " + outStandingBalance + "");
		System.out.println();
	}
	public static void main(String[] args) {
		LoanApplication l = new LoanApplication("Ameer", 500000, 10, 5, 1000);
		l.displayDetails();
		l.makePayment(7000);
		l.setCustomerName("Shaik");
		l.setOutStandingBalance(23000);
		l.setInterestRate(8.6);
		l.setLoanAmount(700000);
		l.setLoanTerm(8);
		l.displayDetails();
	}
	
}


