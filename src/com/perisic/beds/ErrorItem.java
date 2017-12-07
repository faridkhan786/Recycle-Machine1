package com.perisic.beds;

public class ErrorItem extends DepositItem{
	static int size = 0;
//constructor for error Item
	public ErrorItem(){
		value = 0;
		weight = 0;
	}
//get name method in superclass with more appropriate message
public String getName(){
	return "error with Item Inserted";
  }
}
