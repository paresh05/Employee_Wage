package com.bridgelabz2;

class EmpWage
{
	
	public static final int IS_PART_TIME=1;//@param IS_PART_TIME is used to check job status
	public static final int IS_FULL_TIME=2;// @param IS_FULL_TIME is used to check job status

	private String companyName;
	private  int empRatePerHour;
	private  int noOfWorkingDay;
	private  int maxHrsInaMonth;
	private int totalEmpWage;
	
	EmpWage(String companyName, int empRatePerHour, int noOfWorkingDay, int maxHrsInaMonth)
	{
		this.companyName=companyName;
		this.empRatePerHour=empRatePerHour;
		this.noOfWorkingDay=noOfWorkingDay;
		this.maxHrsInaMonth=maxHrsInaMonth;
		
	}
	public void compEmpWage() {
		// variables
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		//Computation
		while(totalEmpHrs <= maxHrsInaMonth && totalWorkingDays < noOfWorkingDay) {
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
		totalEmpWage = totalEmpHrs * empRatePerHour;
		//System.out.println("Total Emp Wage: "+ totalEmpWage);
		// return totalEmpWage;
	}
	
	@Override
	public String toString() {
		return "Total Employee Wage for the company: "+companyName+ " is: "+totalEmpWage;
	}
	
}

public class EmployeeWage {

	public static void main(String[] args) {
		
		EmpWage obj1 = new EmpWage("DMart",20,20,100);
		EmpWage obj2 = new EmpWage("Reliance",30,25,120);
		EmpWage obj3 = new EmpWage("BigBazar",25,15,110);
		
		System.out.println("Welcome to Employee Wage Computation Program");
		
		obj1.compEmpWage();
		System.out.println("Employee Wage of "+obj1);
		
		obj2.compEmpWage();
		System.out.println("Employee Wage of "+obj2);
		
		obj3.compEmpWage();
		System.out.println("Employee Wage of "+obj3);
	}

}
