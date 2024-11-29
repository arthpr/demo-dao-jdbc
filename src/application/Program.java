package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		//seller = sellerDao.findById(2);
		Department department = new Department(3, null);
		//List<Seller> seller = sellerDao.findAll();
		//seller.forEach(System.out::println);
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id: " + newSeller.getId());
	}

}
