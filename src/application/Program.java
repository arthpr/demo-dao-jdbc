package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//Seller seller = sellerDao.findById(2);
		Department department = new Department(3, null);
		List<Seller> seller = sellerDao.findByDepartment(department);
		
		seller.forEach(System.out::println);
	}

}
