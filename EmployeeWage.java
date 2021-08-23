package com.bridgelabz2;


public class EmployeeWage {

	public static void main(String[] args) {
		
		System.out.println("Welcome to employee wage computation");
		int IS_FULL_TIME = 1; // @param IS_FULL_TIME is used to check the status of job
		double empcheck = Math.floor(Math.random() * 10) % 2;
		if (empcheck == IS_FULL_TIME)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is Absent");
	}

}
