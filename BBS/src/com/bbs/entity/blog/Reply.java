/**
 * 
 */
package com.bbs.entity.blog;

import java.util.Date;
import java.util.UUID;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�Reply 
 * �������� ������ʵ��
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��31�� ����8:44:46
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��31�� ����8:44:46
 * �޸ı�ע�� 
 * @version 
 */
public class Reply {

	private String id;
	private String pub_id;
	private String user_id;
	private String content;
	private Date time;
	
	public Reply(){
		id=UUID.randomUUID().toString().replace("-", "");//��UUID����Ψһ��ʶ
	}
	
	//--------------------------------------getter&&setter-----------------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPub_id() {
		return pub_id;
	}
	public void setPub_id(String pub_id) {
		this.pub_id = pub_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
