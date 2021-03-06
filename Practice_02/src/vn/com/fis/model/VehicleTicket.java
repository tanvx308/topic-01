package vn.com.fis.model;

public abstract class VehicleTicket {
	
	private int code;
		
	public VehicleTicket(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return getClass().getName() +  " code=" + code;
	}
	
	
}
