package com.sfu.beans;

public class Evaluation {
	private Integer uid;
	private int num_peo;
	private double score;
	
	
	
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Evaluation(int num_peo, double score) {
		super();
		this.num_peo = num_peo;
		this.score = score;
	}



	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public int getNum_peo() {
		return num_peo;
	}



	public void setNum_peo(int num_peo) {
		this.num_peo = num_peo;
	}



	public double getScore() {
		return score;
	}



	public void setScore(double score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "Evaluation [uid=" + uid + ", num_peo=" + num_peo + ", score="
				+ score + "]";
	}
	
	
}
