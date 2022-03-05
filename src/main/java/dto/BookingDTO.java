package dto;


public class BookingDTO {
	private int bNo;
	private String bCstId;
	private String bCheckin;
	private String bCheckout;
	private int bAdults;
	private int bKids;
	private String bRoomtype;
	
	
	
	public BookingDTO() {}
	
	
	
	public BookingDTO(String bCstId, String bCheckin, String bCheckout, int bAdults, int bKids,
			String bRoomtype) {
		this.bCstId = bCstId;
		this.bCheckin = bCheckin;
		this.bCheckout = bCheckout;
		this.bAdults = bAdults;
		this.bKids = bKids;
		this.bRoomtype = bRoomtype;
	}



//	public BookingDTO(int bNo, String bCstId, String bCheckin, String bCheckout, int bAdults, int bKids,
//			String bRoomtype) {
//		super();
//		this.bNo = bNo;
//		this.bCstId = bCstId;
//		this.bCheckin = bCheckin;
//		this.bCheckout = bCheckout;
//		this.bAdults = bAdults;
//		this.bKids = bKids;
//		this.bRoomtype = bRoomtype;
//	}



	public int getbNo() {
		return bNo;
	}



	public void setbNo(int bNo) {
		this.bNo = bNo;
	}



	public String getbCstId() {
		return bCstId;
	}



	public void setbCstId(String bCstId) {
		this.bCstId = bCstId;
	}



	public String getbCheckin() {
		return bCheckin;
	}



	public void setbCheckin(String bCheckin) {
		this.bCheckin = bCheckin;
	}



	public String getbCheckout() {
		return bCheckout;
	}



	public void setbCheckout(String bCheckout) {
		this.bCheckout = bCheckout;
	}



	public int getbAdults() {
		return bAdults;
	}



	public void setbAdults(int bAdults) {
		this.bAdults = bAdults;
	}



	public int getbKids() {
		return bKids;
	}



	public void setbKids(int bKids) {
		this.bKids = bKids;
	}



	public String getbRoomtype() {
		return bRoomtype;
	}



	public void setbRoomtype(String bRoomtype) {
		this.bRoomtype = bRoomtype;
	}



	@Override
	public String toString() {
		return "BookingDTO [bNo=" + bNo + ", bCstId=" + bCstId + ", bCheckin=" + bCheckin + ", bCheckout=" + bCheckout
				+ ", bAdults=" + bAdults + ", bKids=" + bKids + ", bRoomtype=" + bRoomtype + "]";
	}

}
