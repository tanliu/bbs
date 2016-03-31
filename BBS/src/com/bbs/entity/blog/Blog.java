/**
 * 
 */
package com.bbs.entity.blog;

import java.util.Date;
import java.util.UUID;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�Blog 
 * �������� ������ʵ����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��31�� ����8:26:21
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��31�� ����8:26:21
 * �޸ı�ע�� 
 * @version 
 */
public class Blog {
	private String id;
	private String userId;
	private String title;
	private String content;
	private Date time;
	
	public Blog(){
		id=UUID.randomUUID().toString().replace("-", "");//��UUID����Ψһ��ʶ
	}
	
	//------------------------getter&&setter-----------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


	   
}
