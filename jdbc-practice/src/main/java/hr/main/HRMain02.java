package hr.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class HRMain02 {

	public static List<EmployeeVo> findBySalary(int minSalary, int maxSalary){
		List<EmployeeVo> result = new ArrayList<>();
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("salaryp[min max]> ");
		int mins = scanner.nextInt();
		int maxs = scanner.nextInt();
		
		findBySalary(mins,maxs);
		
		
		scanner.close();
	}

}
