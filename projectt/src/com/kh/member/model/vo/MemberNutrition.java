package com.kh.member.model.vo;

public class MemberNutrition {
	
	private String userId;
	private String Nutrition;
	
	public MemberNutrition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberNutrition(String userId, String nutrition) {
		super();
		this.userId = userId;
		Nutrition = nutrition;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNutrition() {
		return Nutrition;
	}
	public void setNutrition(String nutrition) {
		Nutrition = nutrition;
	}

	@Override
	public String toString() {
		return "MemberNutrition [userId=" + userId + ", Nutrition=" + Nutrition + "]";
	}
	
	

}
