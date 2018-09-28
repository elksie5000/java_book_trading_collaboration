
import java.util.ArrayList;

public class SellerAgent extends Agent{

	private String targetBook;
	private int targetBookIndex;

	private ArrayList<Book> inventory = new ArrayList<Book>(); 
	
	public void receiveTender(String target){
		targetBook = target;
	}
    
    public String getTarget(){
    	return targetBook;
    }

    public void receiveBook(Book book){
		inventory.add(book);
	}

	public void showInventory(){
		System.out.println("Showing inventory...");
		for (int i=0; i < inventory.size(); i++){
			System.out.println(inventory.get(i).getName());
		}
	}
	//check whether title is in inventory. Return price if true, else return -1
	public int checkInventory(){
		int targetInventoryPrice = -1; // acts as boolean
		int i = 0;
		while (i < inventory.size()){
			if (targetBook.equals(inventory.get(i).getName())){
				targetInventoryPrice = inventory.get(i).getPrice();
				//Set targgetBookIndex if it needs to be selected
				targetBookIndex = i;
				//Break after first instance of book in inventory;
				break;
			}
		i++;
		}
		return targetInventoryPrice;
	}

	public Book buyBook(){
		System.out.print("Seller had "+ inventory.size()+ " items...");
		Book transferBook = inventory.get(targetBookIndex);
		inventory.remove(targetBookIndex);
		System.out.print("After sale there are "+ inventory.size()+ " items. Book transferred.");
		return transferBook;
	} 
}

