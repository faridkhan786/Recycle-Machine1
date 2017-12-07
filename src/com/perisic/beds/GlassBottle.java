package com.perisic.beds;

public class GlassBottle extends DepositItem {
	static int size = 8;
public GlassBottle(){
	value = 50;
	weight = 30;
}
public String getName(){
	return "Glass Bottle";
}
}
