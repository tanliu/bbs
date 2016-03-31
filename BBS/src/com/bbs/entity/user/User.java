/**
 * 
 */
package com.bbs.entity.user;

import java.util.Date;
import java.util.UUID;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�User 
 * �������� �û���ʵ����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��31�� ����12:08:38
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��31�� ����12:08:38
 * �޸ı�ע�� 
 * @version 
 */
public class User {
	private String id;
	private String password;
	private String username;
	private int level;
	private String email;
	private Date time;
	
	
	public User(){
		id=UUID.randomUUID().toString().replace("-", "");//��UUID����Ψһ��ʶ
	}
	
	//-------------------------------getter&&setter---------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
	


	
	
	
}
