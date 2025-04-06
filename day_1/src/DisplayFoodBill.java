import java.util.Scanner;
class DisplayFoodBill {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   boolean exit = false;
   int total_bill = 0;
   int quantity = 0;
   int idli = 0;
   int samosa = 0;
   int dosa = 0;

   while(!exit){

    System.out.println("Menu: \n1. Idli \n2. Samosa \n3. Dosa \n0. Display Total Bill");
    switch(sc.nextInt())
    {
	case 1: System.out.println("Enter total quantity");
    		quantity = sc.nextInt();
		idli = 50*quantity;
		break;
	case 2: System.out.println("Enter total quantity");
    		quantity = sc.nextInt();
		samosa = 10*quantity;
		break;
	case 3: System.out.println("Enter total quantity");
    		quantity = sc.nextInt();
		dosa = 60*quantity;
		break;
	case 0: total_bill = idli + samosa + dosa;
                System.out.println("Total Bill is " + total_bill);
		break;
	default: exit = true;
		 System.out.println("Entered wrong choice");
		 break;
    }
   }
  sc.close();
 }
}