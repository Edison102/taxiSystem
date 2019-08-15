package com.sfu.beans;

/**
 * @author Edison
 *
 */
public class Owner {
	private Integer uid;
	private String id_num;   //身份证号
	private String lic_num;  //车牌号
	private String model;   //车型
	private int is_audit;  //是否审核
	private int is_pass;   //是否通过
	
	private Evaluation evaluation;  //车主的评价信息
	private User user;  //车主用户时的信息
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Owner(String id_num, String lic_num, String model, int is_audit,
			int is_pass) {
		super();
		this.id_num = id_num;
		this.lic_num = lic_num;
		this.model = model;
		this.is_audit = is_audit;
		this.is_pass = is_pass;
	}



	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	public String getLic_num() {
		return lic_num;
	}
	public void setLic_num(String lic_num) {
		this.lic_num = lic_num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public int getIs_audit() {
		return is_audit;
	}



	public void setIs_audit(int is_audit) {
		this.is_audit = is_audit;
	}



	public int getIs_pass() {
		return is_pass;
	}



	public void setIs_pass(int is_pass) {
		this.is_pass = is_pass;
	}



	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Owner [uid=" + uid + ", id_num=" + id_num + ", lic_num="
				+ lic_num + ", model=" + model + ", is_audit=" + is_audit
				+ ", is_pass=" + is_pass + ", evaluation=" + evaluation + "]";
	}

	
	
	
	
}
