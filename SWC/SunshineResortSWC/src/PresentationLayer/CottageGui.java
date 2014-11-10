package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ApplicationLayer.Cottage;
import ApplicationLayer.CottageType;
import DataAccessLayer.MakeCottage;
import DataAccessLayer.MakeCottageType;


public class CottageGui implements ActionListener {
	
	JComboBox<Object> typeOfCottageList;
	JFrame frame = new JFrame("Create Cottage");

	JLabel cottageType = new JLabel("Select Cottage Type");
	JLabel noOfBed = new JLabel("Number of bed");
	JLabel typeOfCottage = new JLabel("Type of cottage");
	JLabel cottagePrice = new JLabel("Cottage price");
	
	JTextField noOfBedField = new JTextField();
	JTextField typeOfCottageField = new JTextField();
	JTextField priceOfCottageField = new JTextField();

	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	JButton print = new JButton("Print");
	
	MakeCottage cottages = new MakeCottage();
	MakeCottageType cottageTypes = new MakeCottageType();
	public CottageGui() {
		frame.setSize(450, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); // destroys
																// frame so the
																// program
																// doesn't
																// finish
		JPanel panel1 = new JPanel(new GridLayout(5,1 ));
		
		panel1.add(noOfBed);
		panel1.add(typeOfCottage);
		panel1.add(cottagePrice);
		JPanel center = new JPanel(new GridLayout(5, 1));

		center.add(noOfBedField);
		center.add(typeOfCottageField);
		center.add(priceOfCottageField);
		
		frame.setLayout(new BorderLayout());
		cancel.addActionListener(this);
		save.addActionListener(this);
		print.addActionListener(this);
		
	//	cottageTypes.selectAllCottageTypes();
	//    ArrayList<CottageType> ct = cottages.getCottageTypeList();
		List<CottageType> ct = cottageTypes.selectAllCottageTypes();
	//	for (CottageType cottageType : cottageTypeList) {
	//		System.out.println(cottageType);
	//	}
		
		Object[] ctArray = new CottageType[ct.size()];
		ctArray = ct.toArray();
			
		typeOfCottageList = new JComboBox(ctArray);
		typeOfCottageList.addActionListener(this);
		frame.add(panel1, BorderLayout.WEST);	
		JPanel panel = new JPanel();
		
		panel.add(cottageType);
		panel.add(typeOfCottageList);

		frame.add(panel, BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
		
		
	//	frame.add(panel1,BorderLayout.EAST);

		JPanel south = new JPanel(new GridLayout(1, 5));
		south.add(new JLabel());
		south.add(save);
		south.add(cancel);
//		south.add(clear);
		south.add(print);

		frame.add(south, BorderLayout.SOUTH);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == cancel) {
			frame.dispose();
		}

		if (event.getSource() == save) {
			

		}

	
		if (event.getSource() == typeOfCottageList) // testing method, prints to console
		{
		CottageType test = (CottageType) typeOfCottageList.getSelectedItem();
        typeOfCottageField.setText(test.getTypeOfCottage());
        noOfBedField.setText(String.valueOf(test.getNoOfBed())) ;
        priceOfCottageField.setText(String.valueOf(test.getCottagePrice()));		
        System.out.println(test.getTypeOfCottage());

		}
		
	}
}
