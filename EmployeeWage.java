package com.bridgelabz2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

interface IComputeWage {
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsInaMonth);
	public void computeEmpWage();
}
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

public class EmployeeWage implements IComputeWage {
	
	public static final int IS_PART_TIME=1;//@param IS_PART_TIME is used to check job status
	public static final int IS_FULL_TIME=2;// @param IS_FULL_TIME is used to check job status
	
	private int numOfCompany=0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;
	
	public  EmployeeWage() {
		companyEmpWageList=new LinkedList<>();
		companyToEmpWageMap=new HashMap<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsInaMonth) {
		CompanyEmpWage companyEmpWage=new CompanyEmpWage(company, empRatePerHour,numOfWorkingDays, maxHrsInaMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company,companyEmpWage);
		
	}
	
	public void computeEmpWage() {
		for(int i=0;i<companyEmpWageList.size();i++)
		{
			CompanyEmpWage companyEmpWage=companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
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
		
		IComputeWage empWageBuilder = new EmployeeWage();
		
		empWageBuilder.addCompanyEmpWage("Dmart",20,2,10);
		empWageBuilder.addCompanyEmpWage("Reliance",25,2,12);
		empWageBuilder.addCompanyEmpWage("BigBazar",22,2,15);
		empWageBuilder.addCompanyEmpWage("BigBasket",26,2,11);
		System.out.println("Welcome to Employee Wage Computation Program");
		empWageBuilder.computeEmpWage();
		
		
	}

}
