package com.perisic.beds;
import java.util.Vector; 

/**
 * This is where the data lives, i.e. cans, bottles and crates are recorded
 * in this class. We might call it our database (if we insist!). 
 * It also provides a summative statement about all the items inserted into the 
 * machine. 
 * @author Marc Conrad
 *
 */
public class ReceiptBasis {
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	/**
	 * @param item an item that has been inserted into the machine (such as can, bottle, crate). 
	 */
	public void addItem(DepositItem item) { 
		myItems.add(item); 
		//offsetting the index of the items by 1
		item.number = myItems.indexOf(item) + 1 ; 
	}
	
public int computeWeight(){
	int totalWeight = 0;
	int weight =0;
	for(int i= 0; i < myItems.size(); i++){
		DepositItem item = myItems.get(i);
		totalWeight += item.weight;
		}
	return totalWeight;
}	
	/**
	 * Calculates a summary based on the items inserted.
	 * @param item 
	 * @return the overall value of the items inserted by the customer.
	 */
	public String computeSum() { 
		String receipt = ""; 
		int bottleCount=0,canCount=0,crateCount=0,paperBagCouunt=0,glassbottleCount=0; 
		int totalItems = 0;
		int sum = 0;
	
	for (int i=0; i < myItems.size(); i++){
		DepositItem item = myItems.get(i);
	receipt = receipt + item.number + ":" +item.getName() +":" +item.value;	
	
//switch statement to increase count of particular items 
	switch(item.getName()){
	case "Bottle":
		bottleCount++;
		break;
	case "Can":
		canCount++;
		break;
	case "Paper Bag":
		paperBagCouunt++;
		break;
	case "Glass Bottle":
		glassbottleCount++;
		break;
	}
receipt = receipt + System.getProperty("line.separator");
sum = sum + item.value;
}
//adds the total items together 
	totalItems = bottleCount + canCount+ paperBagCouunt+glassbottleCount;
	//adds the total of each type to the receipt 
receipt = receipt + "Total Bottles:" + bottleCount + "\nTotal cans:" +canCount + "\nTotal crates:" +crateCount + "\nTotal Paper Bags:" +paperBagCouunt + "\nTotal Glass Bottles:" + glassbottleCount;
return receipt;
}
}