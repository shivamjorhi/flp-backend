package com.cg.entities;

public class PasswordEntity {
	private String email;
	private String old_password;
	private String new_password;
	private String confirm_password;
	private String category;
	public PasswordEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordEntity(String email, String old_password, String new_password, String confirm_password,
			String category) {
		super();
		this.email = email;
		this.old_password = old_password;
		this.new_password = new_password;
		this.confirm_password = confirm_password;
		this.category = category;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
