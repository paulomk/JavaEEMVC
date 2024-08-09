package com.cestar.beans;

public class TaxFiler {
	private int filerID;
    private String name;
    private String contact;
    private double annualIncome;
    private double expenses;
    private int taxYear;
    
    //getters and setters
	public int getFilerID() {
		return filerID;
	}
	public void setFilerID(int filerID) {
		this.filerID = filerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

    
	//constructors
	public TaxFiler() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaxFiler(int filerID, String name, String contact, double annualIncome, double expenses, int taxYear) {
		super();
		this.filerID = filerID;
		this.name = name;
		this.contact = contact;
		this.annualIncome = annualIncome;
		this.expenses = expenses;
		this.taxYear = taxYear;
	}
	//to String
	@Override
	public String toString() {
		return "TaxFiler [filerID=" + filerID + ", name=" + name + ", contact=" + contact + ", annualIncome="
				+ annualIncome + ", expenses=" + expenses + ", taxYear=" + taxYear + "]";
	}
	
    
}
