package com.sfu.beans;

/**
 * @author Edison
 *
 */
public class DispatchInfo {
	private Integer id;
	private Integer uid; //车主信息
	private String origin;
	private String start_time;
	private String end_location;
	private int num_peo;
	private int max_peo;
	private double total_price;
	private int is_over;
	public DispatchInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DispatchInfo(Integer uid, String origin, String start_time,
			String end_location, int num_peo, int max_peo, double total_price,
			int is_over) {
		super();
		this.uid = uid;
		this.origin = origin;
		this.start_time = start_time;
		this.end_location = end_location;
		this.num_peo = num_peo;
		this.max_peo = max_peo;
		this.total_price = total_price;
		this.is_over = is_over;
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
	public int getNum_peo() {
		return num_peo;
	}
	public void setNum_peo(int num_peo) {
		this.num_peo = num_peo;
	}
	public int getMax_peo() {
		return max_peo;
	}
	public void setMax_peo(int max_peo) {
		this.max_peo = max_peo;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	public int getIs_over() {
		return is_over;
	}
	public void setIs_over(int is_over) {
		this.is_over = is_over;
	}
	@Override
	public String toString() {
		return "DispatchInfo [id=" + id + ", uid=" + uid + ", origin=" + origin
				+ ", start_time=" + start_time + ", end_location="
				+ end_location + ", num_peo=" + num_peo + ", max_peo="
				+ max_peo + ", total_price=" + total_price + ", is_over="
				+ is_over + "]";
	}
	
	
	
}
