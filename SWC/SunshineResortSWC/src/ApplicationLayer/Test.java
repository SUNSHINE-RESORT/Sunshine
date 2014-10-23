package ApplicationLayer;

import DataAccessLayer.BookingAdmin;
import DataAccessLayer.CottageAdmin;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			CottageAdmin co = new CottageAdmin();
			CottageType ct = new CottageType(7, "Economy",200.00);
			//co.readCottageType("standard");
			//co.readCottage(1);

			co.insertCottageType(ct);
			
			BookingAdmin ba = new BookingAdmin();
			//ba.readTourist(1);
			//ba.readCompany(2);
			
			
	}
}
