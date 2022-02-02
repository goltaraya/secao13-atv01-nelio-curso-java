package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();

		System.out.println("Enter worker data:");

		System.out.print("Name: ");
		String workerName = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		System.out.print("How many contracts to this worker? ");
		int contractsInTotal = sc.nextInt();

		Department department = new Department(departmentName);
		Worker worker = new Worker(workerName, baseSalary, WorkerLevel.valueOf(workerLevel), department);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < contractsInTotal; i++) {
			System.out.println("Contract #" + (i + 1));
			System.out.print("Date (DD/MM/YYYY): ");
			String day = sc.next();
			String month = sc.next();
			String year = sc.next();
			Date date = sdf1.parse(day + "/" + month + "/" + year);

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
		String month = sc.next();
		String year = sc.next();

		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/YYYY");
		Date date = sdf2.parse(month + "/" + year);
		
		// 
		
		sc.close();
	}
}
