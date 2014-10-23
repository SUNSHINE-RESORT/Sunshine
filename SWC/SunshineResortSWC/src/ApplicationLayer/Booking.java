package ApplicationLayer;


public class Booking {
	private int bookingNo;
	private Cottage cottage;
	private Customer customer;
	private String dateFrom;
	private String dateTo;
	private boolean underRenovation;
	private double rentalPrice;
	private boolean paid;
	
	public Booking(int bookingNo, Cottage cottage, Customer customer,
			String dateFrom, String dateTo, boolean underRenovation,
			double rentalPrice, boolean paid) {
		super();
		this.bookingNo = bookingNo;
		this.cottage = cottage;
		this.customer = customer;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.underRenovation = underRenovation;
		this.rentalPrice = rentalPrice;
		this.paid = paid;
	}
	
	
}