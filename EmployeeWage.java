package com.bridgelabz2;

public class EmployeeWage {
	
	public static final int IS_PART_TIME=1;//@param IS_PART_TIME is used to check job status
	public static final int IS_FULL_TIME=2;// @param IS_FULL_TIME is used to check job status
	public static final int EMP_RATE_PER_HOUR=20; // @param EMP_RATE_PER_HOUR is used to assign wage per hour
	public static final int NUM_OF_WORKING_DAYS=20;//@param NUM_OF_WORKING_DAYS is used to assign the working days
	public static final int MAX_HRS_IN_MONTH=100;//@param NUM_OF_WORKING_DAYS is used to assign the working days
	
	public static int compEmpWage() {
		// variables
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		//Computation
		while(totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
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
		int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
		System.out.println("Total Emp Wage: "+ totalEmpWage);
		return totalEmpWage;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		compEmpWage();
	}

}
