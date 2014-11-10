package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Administration implements ActionListener
{
	JFrame frame = new JFrame("Sunshine Cottage Administration");
	JButton btnBooking;
	JButton btnCottageStatus;
	JButton btnCottageType;
	JButton btnCottage;

	JTextArea ta;


	public Administration() throws SQLException
	{
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JPanel panel ;
		panel = new JPanel(new GridLayout(1,2));
		btnBooking = new JButton("Make Booking");
		btnCottageStatus = new JButton("Cottage Status");
		btnCottageType = new JButton("Create Cottage Type");
		btnCottage = new JButton("Create cottage");	
		btnCottageType.addActionListener(this);
		btnCottage.addActionListener(this);
		panel.add(btnBooking);
		panel.add(btnCottageStatus);
		panel.add(btnCottageType);
		panel.add(btnCottage);
		
		frame.add(panel,BorderLayout.NORTH);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
     if(e.getSource() == btnCottage){
    	 new CottageGui();
     }
    	if(e.getSource() == btnCottageType) {
    		new CottageTypeGui();
    	}
	}

	public static void main(String[] args) throws SQLException
	{
		new Administration();

	}

}
