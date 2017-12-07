package com.perisic.peripherals;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.perisic.beds.CustomerPanel;
import com.perisic.beds.PrinterInterface;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * This class combines three different aspects: 
 * 1) Starting the software
 * 2) Implementing the GUI
 * 3) Handling events
 * 
 * To do: (Task 3) - refactor into more than one class to separate the different aspects. 
 * @author Marc Conrad
 *
 */
public class RecyclingGUI extends JFrame implements ActionListener,PrinterInterface  {
	CustomerPanel myCustomerPanel = new CustomerPanel(this);
	Random rand = new Random();
	/**
	 * 
	 */
	private static final long serialVersionUID = -1077856539035586635L;

	public void actionPerformed(ActionEvent e) {
		/*
		 System.out.println("Received: e.getActionCommand()="+e.getActionCommand()+
									" e.getSource()="+e.getSource().toString() ); 
									*/
		if( e.getSource().equals(slot1)) { 
			myCustomerPanel.itemReceived(1);
		} else if( e.getSource().equals(slot2)) { 
			myCustomerPanel.itemReceived(2);
		} else if(e.getSource().equals(slot3)) { 
			myCustomerPanel.itemReceived(3);
		} else if(e.getSource().equals(slot4)) { 
			myCustomerPanel.itemReceived(4);
		} else if(e.getSource().equals(slot5)) { 
			myCustomerPanel.itemReceived(5);
				
		} else if (e.getSource().equals(emptyMachine)){
			slot1.setVisible(true);
			slot2.setVisible(true);
			slot3.setVisible(true);
			slot4.setVisible(true);
			slot5.setVisible(true);
			slot6.setVisible(true);
			receipt.setVisible(true);
			emptyMachine.setVisible(false);
			progressBar.setString(null);
			progressBar.setValue(0);
			output.setText("Machine Cleared");
		} else if (e.getSource().equals(slot6)){ 
			//To domenstrate when user inputs random items and potenial incorrect items 
			myCustomerPanel.itemReceived(rand.nextInt(10));
		} else if(e.getSource().equals(receipt)) { 
			myCustomerPanel.printReceipt();
		}
	}
	JButton slot1 = new JButton("CAN"); 
	JButton slot2 = new JButton("BOTTLE"); 
	JButton slot3 = new JButton("CRATE"); 
	JButton slot4 = new JButton("Paper Bag"); 
	JButton slot5 = new JButton("Glass Bottle"); 
	JButton slot6 = new JButton("Random Entry"); 
	JButton emptyMachine = new JButton("Empty Machine");
	JProgressBar progressBar = new JProgressBar();
	
//Creating the JText area for the printing of the receipt 
	JTextArea output = new JTextArea(10,55);
	JScrollPane scrollPane = new JScrollPane(output);
	JButton receipt = new JButton("Print Receipt"); 
	JPanel Panel = new JPanel();
	Font font = new Font("Courier", Font.PLAIN,12);
	//Constructs the recylingGUI object and makes it 
	//visible and seat parameters as well as adding all components 
	public RecyclingGUI() {
		super();
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(slot1); 
		panel.add(slot2);
		panel.add(slot3); 
		panel.add(slot4); 
		panel.add(slot5); 
		panel.add(slot6); 
		panel.add(emptyMachine);
		slot1.addActionListener(this); 
		slot2.addActionListener(this); 
		slot3.addActionListener(this); 
		slot4.addActionListener(this); 
		slot5.addActionListener(this); 
		slot6.addActionListener(this); 
		emptyMachine.addActionListener(this);
		emptyMachine.setVisible(false);
		panel.add(receipt); 
		receipt.addActionListener(this); 
		output.setFont(font);
		//adding the text area within the scroll pane to the panel
		panel.add(scrollPane);
		panel.add(progressBar);
		
		progressBar.setStringPainted(true);
		getContentPane().add(panel);
		panel.repaint();
	}
	
	//main method to run the program
	//@param args
	public static void main(String [] args){
		RecyclingGUI myGUI = new RecyclingGUI();
		myGUI.setVisible(true);
	}
	
	//@Override
	public void print(String str){
		System.out.println(str);
		output.setText(str);
	//sets the progress bar value 
		if(myCustomerPanel.calculatePersentage()<=100){
			progressBar.setValue((int)myCustomerPanel.calculatePersentage());
		} else {
			progressBar.setValue(100);
		//trigger the full machine warning
		progressBar.setString("THE MACHINE IS OVERFULL");
		slot1.setVisible(false);
		slot2.setVisible(false);
		slot3.setVisible(false);
		slot4.setVisible(false);
		slot5.setVisible(false);
		slot6.setVisible(false);
		emptyMachine.setVisible(true);
		}
	}
}
	
		
		
	
	

