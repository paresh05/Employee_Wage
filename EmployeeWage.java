package com.bridgelabz2;


public class EmployeeWage {
	
	public static final int IS_Part_Time = 1;// @param IS_Part_Time is used to check job status
	public static final int WAGE_PER_HR =20; // @param WAGE_PER_HR is used to assign wage per hour
	public static final int IS_FULL_TIME = 2; // @param IS_FULL_TIME is used to check job status
	public static final int NUM_OF_WORKING_DAYS=20;//@param NUM_OF_WORKING_DAYS is used to assign the working days
	public static final int MAX_HRS_IN_MONTH=100;//@param MAX_HRS_IN_MONTH is used to assign max hrs in a month
	

	public static void main(String[] args) {
		
		System.out.println("Welcome to employee wage computation");
		
		int empHrs =0;
        int empWage = 0;
        int totalWorkingDays = 0,totalEmpHrs=0;

		// Computation
        while(totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
			totalWorkingDays++;
			int empCheck = (int) Math.floor(Math.random()*10) % 3;
			switch (empCheck) {
			case IS_Part_Time:
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
		int totalEmpWage = totalEmpHrs * WAGE_PER_HR;
		System.out.println("Total Emp Wage: "+ totalEmpWage);

	}

}
