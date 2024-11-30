package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerProgram {

	private static SellerDao sellerDao = DaoFactory.createSellerDao();
	private static DepartmentDao departmentDao = DaoFactory.creteDepartmentDao();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void editSellers() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - insert");
		System.out.println("2 - update");
		System.out.println("3 - delete by id");
		System.out.println("4 - find by id");
		System.out.println("5 - find all");
		System.out.println("6 - find by department");
		int i = sc.nextInt();
		sc.nextLine();
		switch (i) {
		case 1:
			insertSeller();
			break;
		case 2:
			updateSeller();
			break;
		case 3:
			deleteSeller();
			break;
		case 4:
			findSeller();
			break;
		case 5:
			findAllSellers();
			break;
		case 6:
			findByDepartment();
			break;
		default:
			System.out.println("Invalid option!");
			break;
		}
		
		sc.close();
	}
	
	public static void insertSeller() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (dd/mm/yyyy): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		System.out.print("Department Id: ");
		int departmentId = sc.nextInt();
		sc.nextLine();
		Department department = departmentDao.findById(departmentId);
		Seller newSeller = new Seller(null, name, email, birthDate, baseSalary, department);
		sellerDao.insert(newSeller);
		
		sc.close();
	}
	
	public static void updateSeller() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seller id to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Seller sellerToUpdate = sellerDao.findById(id);
		System.out.println("Set:");
		System.out.println("1 - Name");
		System.out.println("2 - Email");
		System.out.println("3 - Birth Date (dd/mm/yyyy)");
		System.out.println("4 - Base Salary");
		System.out.println("5 - Department Id");
		int i = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter new: ");
		switch (i) {
		case 1:
			sellerToUpdate.setName(sc.nextLine());
			break;
		case 2:
			sellerToUpdate.setEmail(sc.nextLine());
			break;
		case 3:
			sellerToUpdate.setBirthDate(sdf.parse(sc.nextLine()));
			break;
		case 4:
			sellerToUpdate.setBaseSalary(sc.nextDouble());
			break;
		case 5:
			sellerToUpdate.getDepartment().setId(sc.nextInt());
			sc.nextLine();
			break;
		default:
			System.out.println("Invalid option!");
		}
		sellerDao.update(sellerToUpdate);
		
		sc.close();
	}
	
	public static void deleteSeller() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seller Id to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		sellerDao.deleteById(id);
				
		sc.close();
	}
	
	public static void findSeller() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seller Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		sellerDao.findById(id);
				
		sc.close();
	}
	
	public static void findAllSellers() {
		
		List<Seller> sellers = sellerDao.findAll();
		sellers.forEach(System.out::println);
	}
	
	public static void findByDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Department id: ");
		int id = sc.nextInt();
		sc.nextLine();
		Department dep = departmentDao.findById(id);
		List<Seller> sellers = sellerDao.findByDepartment(dep);
		sellers.forEach(System.out::println);
		
		sc.close();
	}
}
