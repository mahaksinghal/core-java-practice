package functional_streams;

import com.shop.core.*;
import java.util.Map;
import java.util.Scanner;

import com.shop.core.Product;

import static com.shop.utils.ShopUtils.*;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Display the count products from the map with specified category 
		 * & price > min price
		 */
		try(Scanner sc = new Scanner(System.in)){
			// get product map
			Map<Integer, Product> productMap = populateProductMap(populateProductList());
			System.out.println("Enter category and min price");
			Category cat = Category.valueOf(sc.next().toUpperCase());
			double minPrice = sc.nextDouble();
			/*
			 * map --> values() --> collection --> stream --> Stream --> filters --> count
			 */
			
			long count = productMap.values()	// Collection<Product
			.stream()			// Stream<Product>
			.filter(p -> (p.getProductCategory()==cat) && (p.getPrice() > minPrice))
			.count();
			
			System.out.println(" Number of filtered Products "+count);
			
			productMap.values()	// Collection<Product
			.stream()			// Stream<Product>
			.filter(p -> (p.getProductCategory()==cat) && (p.getPrice() > minPrice))
			.forEach(p -> System.out.println(p));
		}
		
	}

}












