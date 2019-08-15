package com.sfu.beans;

/**
 * @author Edison
 *
 */
public class Orders {
	private Integer id;
	private Integer uid;
	private String origin;
	private String start_time;
	private String end_location;
	private double payment;
	private int is_pay;
	
	private DispatchInfo dispatchInfo;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer uid, String origin, String start_time,
			String end_location, double payment, int is_pay) {
		super();
		this.uid = uid;
		this.origin = origin;
		this.start_time = start_time;
		this.end_location = end_location;
		this.payment = payment;
		this.is_pay = is_pay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_location() {
		return end_location;
	}

	public void setEnd_location(String end_location) {
		this.end_location = end_location;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	

	public int getIs_pay() {
		return is_pay;
	}

	public void setIs_pay(int is_pay) {
		this.is_pay = is_pay;
	}

	public DispatchInfo getDispatchInfo() {
		return dispatchInfo;
	}

	public void setDispatchInfo(DispatchInfo dispatchInfo) {
		this.dispatchInfo = dispatchInfo;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", origin=" + origin
				+ ", start_time=" + start_time + ", end_location="
				+ end_location + ", payment=" + payment + ", is_pay=" + is_pay
				+ ", dispatchInfo=" + dispatchInfo + "]";
	}
	
	
	
}
