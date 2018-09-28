
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class BookTrade
{





public static void main(String[] args){

	//Create an array for the randomly created titles for books
	String[] titles = new String[100];
	//generate titles for first 80 titles
	for (int i = 0; i < 80; i++){
		titles[i] = "Book" + Integer.toString(i);
	}
	//Generate single duplicate numbers to replicate multiple copies of books
	final int[] dupes = new Random().ints(1, 80).distinct().limit(20).toArray();

	System.out.println("Duplicate book numbers: "+ Arrays.toString(dupes));
	//Add these to the existing array
	for (int i = 1; i < dupes.length; i++){
		titles[i+80] = "Book" + Integer.toString(dupes[i]);

	}

	//Create an inventory array
	Book[] bookInventory = new Book[titles.length];
	//For each title also create a random price.
	for( int i = 0; i < titles.length; i++){
		Book book = new Book(titles[i]);
		bookInventory[i] = book;
	}
	

	//initialise booking agent
	BuyerAgent bookie = new BuyerAgent();
	bookie.setID("buyer1");

	//Ask for book to find
	Scanner keyboard = new Scanner(System.in);
	System.out.println ("Enter the book number (title) you want to find (e.g. 1)?");
    String bookTarget = "Book" + Integer.toString(keyboard.nextInt());
    System.out.println ("How many seller agents do you want to initialise?");
    int sellerNumber = keyboard.nextInt();

	SellerAgent[] sellers = new SellerAgent[sellerNumber];

	for (int i = 0; i < sellers.length; i++){
		sellers[i] = new SellerAgent();
		sellers[i].setID("seller" + Integer.toString(i));
		System.out.println("Initialising: " + sellers[i].getID());
	}

	Collections.shuffle(Arrays.asList(bookInventory));

	//distribute books
	int count = 0;
	while (count < bookInventory.length){
		for (int i = 0; i < sellers.length; i++){
			sellers[i].receiveBook(bookInventory[count]);
			count++;
		}
	}

	

	bookie.setTarget(bookTarget);
	System.out.println ("Issuing bid for  "+"Book"+
		bookTarget+ ".");
	

	
	//issue tenders to all seller agents
	for (int i = 0; i < sellers.length; i++){
		bookie.issueTender(sellers[i]);
	}


	//issue tenders to all seller agents
	for (int i = 0; i < sellers.length; i++){
		sellers[i].getID();
		bookie.queryAgent(sellers[i]);
		bookie.reportResult();
		//if(bookie.queryAgent(sellers[i]))
	}

	//Transfer book and report result
	bookie.transferBook();
	bookie.reportTransfer();
	
	}
}

