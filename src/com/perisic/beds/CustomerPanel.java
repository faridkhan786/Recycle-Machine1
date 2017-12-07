package com.perisic.beds;

/**
 * This is the interface of the system. It represents the interaction from 
 * the customer with the system. 
 * The customer panel knows the recycling machine (i.e. the Deposit Item Receiver class)
 * @author Marc Conrad
 *
 */
public class CustomerPanel {
	//create a new deposit item receiver 
	DepositItemReceiver receiver = null; 

public void itemReceived(int slot) {
	receiver.classifyItem(slot);
}
//Calculates percentage
public float calculatePersentage(){
	return receiver.calculateWeightPersentage();
}

//constructor for CustomerPanel specify the printer to print with as parameter 
public CustomerPanel(PrinterInterface printer){
   super();
   receiver = new DepositItemReceiver(printer);
}
//print the receipt
public void printReceipt(){
	receiver.printReceipt();
   }
}