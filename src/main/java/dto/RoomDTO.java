package dto;

public class RoomDTO {

	private String rId;
	private String rType; //Single or Double or Deluxe
	private int rPrice;
	private String rBedsize; // s/m/l
	
	
	
	public RoomDTO() {}



	public RoomDTO(String rId, String rType, int rPrice, String rBedsize) {
		super();
		this.rId = rId;
		this.rType = rType;
		this.rPrice = rPrice;
		this.rBedsize = rBedsize;
	}



	public String getrId() {
		return rId;
	}



	public void setrId(String rId) {
		this.rId = rId;
	}



	public String getrType() {
		return rType;
	}



	public void setrType(String rType) {
		this.rType = rType;
	}



	public int getrPrice() {
		return rPrice;
	}



	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}



	public String getrBedsize() {
		return rBedsize;
	}



	public void setrBedsize(String rBedsize) {
		this.rBedsize = rBedsize;
	}



	@Override
	public String toString() {
		return "RoomDTO [rId=" + rId + ", rType=" + rType + ", rPrice=" + rPrice + ", rBedsize=" + rBedsize + "]";
	}
	
}
