package io.virjid.retirement.dto;

import java.time.LocalDate;

public class AccountContext {
	private String id;              // 唯一的ID号
	
	private String account;         // 账户
	
	private String name;            // 姓名
	private LocalDate birthday;     // 生日
	private Boolean male;           // 性别
	private String address;         // 地址
	private String idCard;          // 身份证
	private String contact;         // 联系方式
	
	private Integer role;               // 角色
	private Integer status;             // 账号状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Boolean isMale() {
		return male;
	}
	public void setMale(Boolean male) {
		this.male = male;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountContext [id=" + id + ", account=" + account + ", name=" + name + ", birthday=" + birthday
				+ ", male=" + male + ", address=" + address + ", idCard=" + idCard + ", contact=" + contact + ", role="
				+ role + ", status=" + status + "]";
	}
}
