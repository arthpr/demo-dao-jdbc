package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentProgram {

	private static DepartmentDao departmentDao = DaoFactory.creteDepartmentDao();
	
	public static void editDepartments() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - insert");
		System.out.println("2 - update");
		System.out.println("3 - delete by id");
		System.out.println("4 - find by id");
		System.out.println("5 - find all");
		int i = sc.nextInt();
		sc.nextLine();
		switch (i) {
		case 1: 
			insertDepartment();
			break;
		case 2:
			updateDepartment();
			break;
		case 3:
			deleteDepartment();
			break;
		case 4:
			findDepartment();
			break;
		case 5:
			findAllDepartments();
			break;
		default:
			System.out.println("Invalid option!");
		}
				
		sc.close();
	}
	
	public static void insertDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Department name: ");
		String name = sc.nextLine();
		Department dep = new Department(null, name);
		departmentDao.insert(dep);
		
		sc.close();
	}
	
	public static void updateDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Department id to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Department dep = departmentDao.findById(id);
		System.out.println("New name: ");
		String name = sc.nextLine();
		dep.setName(name);
		departmentDao.update(dep);
		
		sc.close();
	}
	
	public static void deleteDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Department id to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		departmentDao.deleteById(id);
		
		sc.close();
	}
	
	public static void findDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Department id to find: ");
		int id = sc.nextInt();
		sc.nextLine();
		departmentDao.findById(id);
		
		sc.close();
	}
	
	public static void findAllDepartments() {
		
		List<Department> departments = departmentDao.findAll();
		departments.forEach(System.out::println);
	}
}
