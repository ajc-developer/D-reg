package com.drexel.d_reg;

class Class{
	private String crn;
	private String nickName;
	
	public Class(String crn, String name){
		this.crn = crn;
		this.nickName = name;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}