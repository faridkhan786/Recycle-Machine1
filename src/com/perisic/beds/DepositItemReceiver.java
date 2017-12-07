package com.perisic.beds;

/** 
 * This class represents the overall system. 
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	ReceiptBasis theReceiptBasis = null; 
	PrinterInterface printer = null; 
	
public void createReceiptBasis() { 
	theReceiptBasis = new ReceiptBasis(); 
	}
	
// calculates the weight persentage based on the items inserted 
//return

public float calculateWeightPersentage(){
	float persentage;
	int weight =0;
	int maxWeight = 2000;
	try {
		weight = theReceiptBasis.computeWeight();
	}
	catch(Exception e){
	}
	persentage = (weight*100/maxWeight);
	return persentage;
}

//method used to determine which type of item used based on the slot
//parameter

public void classifyItem(int slot) { 
		DepositItem item = null; 
		if( slot == 1 ) { 
			item = new Bottle(); 
		} else if( slot == 2 ) { 
			item = new Can(); 
		} else if ( slot == 3 ) { 
			item = new Crate(); 
		} else if (slot == 4) { 
			item = new PaperBag();
		} else if (slot == 5) { 
			item = new GlassBottle();
		} else { 
			item = new ErrorItem(); 
		}
//determines weather or not receipt basis has been created 
//if it is still null then create receipt and add the determined 
//item
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item); 
	}
//initialise depositItemReceiver with printer where output goes
public DepositItemReceiver(PrinterInterface printer){
	super();
	this.printer = printer;
}
//prints the receipt
	public void printReceipt() { 
		String str = "";
		try{
			str = theReceiptBasis.computeSum();
		}catch(Exception e){
			str = "an error occured with item entry, you don't enter any items";
		}
		printer.print(str);
		theReceiptBasis = null;
	}
}
