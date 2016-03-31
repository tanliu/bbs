/**
 * 
 */
package com.bbs.entity.blog;

import java.util.Date;
import java.util.UUID;

/** 
 * 项目名称：BBS
 * 类名称：Blog 
 * 类描述： 发帖的实体类
 * 创建人：坛子
 * 创建时间：2016年3月31日 上午8:26:21
 * 修改人：TanLiu 
 * 修改时间：2016年3月31日 上午8:26:21
 * 修改备注： 
 * @version 
 */
public class Blog {
	private String id;
	private String userId;
	private String title;
	private String content;
	private Date time;
	
	public Blog(){
		id=UUID.randomUUID().toString().replace("-", "");//用UUID生成唯一标识
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
