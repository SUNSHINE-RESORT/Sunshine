package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ApplicationLayer.Cottage;
import ApplicationLayer.CottageType;
import DataAccessLayer.CottageAdmin;

public class CottageGui implements ActionListener {

	JFrame frame = new JFrame("Add Cottage Type");
	JLabel noOfBed = new JLabel("Number of bed");
	JLabel typeOfCottage = new JLabel("Type of Cottage");
	JLabel cottagePrice = new JLabel("Cottage Price");

	JTextField noOfBedField = new JTextField(10);
	JTextField typeOfCottageField = new JTextField(10);
	JTextField cottagePriceField = new JTextField(10);


	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	JButton clear = new JButton("Clear");
	JButton print = new JButton("Print");

	public CottageGui() {
		frame.setSize(500, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); // destroys
																// frame so the
																// program
																// doesn't
																// finish

		frame.setLayout(new BorderLayout());

		JPanel west = new JPanel(new GridLayout(5, 1));
		west.add(noOfBed);
		west.add(typeOfCottage);
		west.add(cottagePrice);

		frame.add(west, BorderLayout.WEST);
		cancel.addActionListener(this);
		save.addActionListener(this);
		clear.addActionListener(this);
		print.addActionListener(this);
		JPanel center = new JPanel(new GridLayout(5, 1));


		center.add(noOfBedField);
		center.add(typeOfCottage);
		center.add(cottagePriceField);


		frame.add(center, BorderLayout.CENTER);

		JPanel south = new JPanel(new GridLayout(1, 5));
		south.add(new JLabel());

		south.add(save);
		south.add(cancel);
		south.add(clear);
		south.add(print);

		frame.add(south, BorderLayout.SOUTH);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == cancel) {
			frame.dispose();
		}

		if (event.getSource() == save) {


			noOfBedField.setText("");
			typeOfCottage.setText("");
			cottagePriceField.setText("");


		}

		if (event.getSource() == clear) // resets text fields
		{
			noOfBedField.setText("");
			typeOfCottageField.setText("");
			cottagePriceField.setText("");

		}

		if (event.getSource() == print) // testing method, prints to console
		{
		

			// alist.addGuestListToDB(guest);
		}
	}
}
