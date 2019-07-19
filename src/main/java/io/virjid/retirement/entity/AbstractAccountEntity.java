package io.virjid.retirement.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public abstract class AbstractAccountEntity implements Serializable {
	private static final long serialVersionUID = -1277738782320198390L;
	
	public static final int ROLE_STAFF=0,ROLE_MANAGER=1,ROLE_USER=2;
	public static final int STATUS_NORMAL=0,STATUS_FREEZE=1,STATUS_INVALID=2;
	
	private String id;              // 唯一的ID号
	
	private String account;         // 账户
	private String password;        // 密码
	
	private String name;            // 姓名
	private LocalDate birthday;     // 生日
	private Boolean male;           // 性别
	private String address;         // 地址
	private String idCard;          // 身份证
	private String contact;         // 联系方式
	
	private int role;               // 角色
	private int status;             // 账号状态
}
