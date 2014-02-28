package com.android.dopewars;

public class User {
	
	
	private int Drugs[];
	private long Cash, Debt, Savings;
	private long DrugPrices[];
	private int Coat, Guns;
	private int Days, copCount, Location;
	//String LocationName;
	
	
	public User() {
		super();
		this.Drugs = new int[8];
		this.DrugPrices = new long [8];
		this.Cash = 2000;
		this.Debt = 5500;
		this.Savings = 0;
		this.Coat = 100;
		this.Guns = 0;
		this.Days = 31;
		this.copCount = 3;
		this.Location = 0;
	}
		
	
	/**
	 * @return the Drugs
	 */
	public int[] getDrugs() {
		return Drugs;
	}

	/**
	 * @param Drugs the Drugs to set
	 */
	public void setDrugs(int drug, int amount) {
		this.Drugs[drug] = amount;
	}
	
	/**
	 * @param Drugs the Drugs to set
	 */
	public void setDrugs(int Drugs[]) {
		this.Drugs = Drugs;
	}

	/**
	 * @return the Cash
	 */
	public long getCash() {
		return Cash;
	}


	/**
	 * @param Cash the Cash to set
	 */
	public void setCash(long Cash) {
		this.Cash = Cash;
	}


	/**
	 * @return the Debt
	 */
	public long getDebt() {
		return Debt;
	}


	/**
	 * @param Debt the Debt to set
	 */
	public void setDebt(long Debt) {
		this.Debt = Debt;
	}


	/**
	 * @return the Savings
	 */
	public long getSavings() {
		return Savings;
	}


	/**
	 * @param Savings the Savings to set
	 */
	public void setSavings(long Savings) {
		this.Savings = Savings;
	}


	/**
	 * @return the drugPrices
	 */
	public long[] getDrugPrices() {
		return DrugPrices;
	}


	/**
	 * @param drugPrices the drugPrices to set
	 */
	public void setDrugPrices(long DrugPrices[]) {
		this.DrugPrices = DrugPrices;
	}


	/**
	 * @return the Coat
	 */
	public int getCoat() {
		return Coat;
	}


	/**
	 * @param Coat the Coat to set
	 */
	public void setCoat(int Coat) {
		this.Coat = Coat;
	}


	/**
	 * @return the Guns
	 */
	public int getGuns() {
		return Guns;
	}


	/**
	 * @param Guns the Guns to set
	 */
	public void setGuns(int Guns) {
		this.Guns = Guns;
	}


	/**
	 * @return the DrugsSum
	 */
	public int getDrugsSum() {
		int DrugsSum = 0;
		for( int i = 0; i < 8; i++){
			DrugsSum += Drugs[i];
		}
		return DrugsSum;
	}

	/**
	 * @return the timeLeft
	 */
	public int getDays() {
		return Days;
	}


	/**
	 * @param timeLeft the timeLeft to set
	 */
	public void setTimeLeft(int Days) {
		this.Days = Days;
	}


	/**
	 * @return the copCount
	 */
	public int getCopCount() {
		return copCount;
	}


	/**
	 * @param copCount the copCount to set
	 */
	public void setCopCount(int copCount) {
		this.copCount = copCount;
	}


	/**
	 * @return the Location
	 */
	public int getLocation() {
		return Location;
	}


	/**
	 * @param Location the Location to set
	 */
	public void setLocation(int Location) {
		this.Location = Location;
	} 
	
	
}
