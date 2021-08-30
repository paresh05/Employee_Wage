package com.bridgelabz2;

class CompanyEmpWage
{
	public String companyName;
	public  int empRatePerHour;
	public  int noOfWorkingDay;
	public  int maxHrsInaMonth;
	public  int totalEmpWage;
	
	CompanyEmpWage(String companyName, int empRatePerHour, int noOfWorkingDay, int maxHrsInaMonth)
	{
		this.companyName=companyName;
		this.empRatePerHour=empRatePerHour;
		this.noOfWorkingDay=noOfWorkingDay;
		this.maxHrsInaMonth=maxHrsInaMonth;
		
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	
	
	@Override
	public String toString() {
		return "Total Employee Wage for the company: "+companyName+ " is: "+totalEmpWage;
	}
	
}

public class EmployeeWage {
	
	public static final int IS_PART_TIME=1;//@param IS_PART_TIME is used to check job status
	public static final int IS_FULL_TIME=2;// @param IS_FULL_TIME is used to check job status
	
	private int numOfCompany=0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	public  EmployeeWage() {
		companyEmpWageArray=new CompanyEmpWage[3];
	}
	
	private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsInaMonth) {
		companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company, empRatePerHour,numOfWorkingDays, maxHrsInaMonth);
		numOfCompany++;
	}
	
	private void computeEmpWage() {
		for(int i=0;i<numOfCompany;i++)
		{
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		// variables
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		//Computation
		while(totalEmpHrs <= companyEmpWage.maxHrsInaMonth && totalWorkingDays < companyEmpWage.noOfWorkingDay) {
			totalWorkingDays++;
			int empCheck = (int) Math.floor(Math.random()*10) % 3;
			switch (empCheck) {
			case IS_PART_TIME:
				empHrs = 4;
				break;
			case IS_FULL_TIME:
				empHrs = 8;
				break;
			default:
				empHrs = 0;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day: " + totalWorkingDays + " Emp Hr: " +empHrs);
		}
		return totalEmpHrs*companyEmpWage.empRatePerHour;
	}

	public static void main(String[] args) {
		
		EmployeeWage empWageBuilder = new EmployeeWage();
		
		empWageBuilder.addCompanyEmpWage("Dmart",20,2,10);
		empWageBuilder.addCompanyEmpWage("Reliance",25,2,12);
		empWageBuilder.addCompanyEmpWage("BigBazar",22,2,15);
		System.out.println("Welcome to Employee Wage Computation Program");
		empWageBuilder.computeEmpWage();
		
		
	}

}
