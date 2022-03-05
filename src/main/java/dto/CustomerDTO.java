package dto;

public class CustomerDTO {

	private String cId;
	private String cNname;
	private String cPw;
	
	
	public CustomerDTO() {}


	public CustomerDTO(String cId, String cNname, String cPw) {
		super();
		this.cId = cId;
		this.cNname = cNname;
		this.cPw = cPw;
	}


	public String getcId() {
		return cId;
	}


	public void setcId(String cId) {
		this.cId = cId;
	}


	public String getcNname() {
		return cNname;
	}


	public void setcNname(String cNname) {
		this.cNname = cNname;
	}


	public String getcPw() {
		return cPw;
	}


	public void setcPw(String cPw) {
		this.cPw = cPw;
	}


	@Override
	public String toString() {
		return "CustomerDTO [cId=" + cId + ", cNname=" + cNname + ", cPw=" + cPw + "]";
	}


}
