package application;

import java.text.ParseException;
import java.util.Scanner;

import db.DbException;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try 
		{
			System.out.println("Sales System Database");
			System.out.println();
			System.out.println("1 - Edit Sellers");
			System.out.println("2 - Edit Departments");
			int i = sc.nextInt();
			sc.nextLine();
			
			switch (i) {
			case 1:
				SellerProgram.editSellers();
				break;
			case 2:
				DepartmentProgram.editDepartments();
				break;
			default:
				System.out.println("Invalid option!");
			}
		}
		catch (ParseException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}
