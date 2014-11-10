package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ApplicationLayer.CottageType;
import DataAccessLayer.MakeCottageType;

public class CottageTypeGui implements ActionListener {

	JFrame frame = new JFrame("Create Cottage Type");
	MakeCottageType mct = new MakeCottageType();

	JLabel noOfBed = new JLabel("Enter the number of bed: ");
	JLabel typeOfCottage = new JLabel("Enter the type of cottage: ");
	JLabel priceOfCottage = new JLabel("Enter the cottage price: ");

	JTextField noOfBedField = new JTextField(8);
	JTextField typeOfCottageField = new JTextField(8);
	JTextField priceOfCottageField = new JTextField(8);

	JButton btnSave = new JButton("Save");
	JButton btnCancel = new JButton("Cancel");

	public CottageTypeGui() {
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); // destroys
																// frame so the
																// program
																// doesn't
																// finish

		frame.setLayout(new BorderLayout());

		JPanel west = new JPanel(new GridLayout(4, 1));
		west.add(noOfBed);
		west.add(typeOfCottage);
		west.add(priceOfCottage);

		frame.add(west, BorderLayout.WEST);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		JPanel center = new JPanel(new GridLayout(4, 1));

		center.add(noOfBedField);
		center.add(typeOfCottageField);
		center.add(priceOfCottageField);		
		frame.add(center, BorderLayout.CENTER);
		
		JPanel south = new JPanel(new GridLayout(1, 2));
		south.add(new JLabel());
		south.add(btnSave);
		south.add(btnCancel);
		frame.add(south, BorderLayout.SOUTH);
		frame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == btnSave) {
			CottageType cottageType = new CottageType(Integer.parseInt(noOfBedField.getText()),typeOfCottageField.getText(), Double.parseDouble(priceOfCottageField.getText()));
			mct.insertCottageType(cottageType);
			noOfBedField.setText("");
			typeOfCottageField.setText("");
			priceOfCottageField.setText("");
		}

		
		if (event.getSource() == btnCancel) {
			frame.dispose();
		}
	}
}
