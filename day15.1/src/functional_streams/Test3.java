package functional_streams;

import static com.shop.utils.ShopUtils.populateProductList;

import java.util.List;

import com.shop.core.Product;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * get product list from utils and display the products using Stream API
		 * List<Product> ---> stream() --> Stream<Product> -->forEach
		 */
		List<Product> productList = populateProductList();
		
		/*
		 * API of Collection i/f
		 * public default Stream<T> stream() - for seq accessed stream
		 */
		System.out.println("All products accesses in sequencial manner");
		productList.stream()
		.forEach(p->System.out.println(p));
		
		/*
		 * API of Collection i/f
		 * public default Stream<T> parallelStream() - for parallel accessed stream
		 */
		
		System.out.println("\nAll products accesses in parallel manner\n");
		productList.parallelStream()
		.forEach(p -> System.out.println(p));
		
	}

}













