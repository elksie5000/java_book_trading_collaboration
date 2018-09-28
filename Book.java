import java.util.Random;

public class Book
{
	
	private String name;
	private int price;


	public Book(String bookName) 
	{
		this.name = bookName;
		Random r = new Random();
		int lowPrice = 10;
		int highPrice = 100;
		this.price = r.nextInt(highPrice - lowPrice) + lowPrice;
	}

	public String getName()
	{
		return name;
	}

	public int getPrice()
	{
		return price;
	}
}