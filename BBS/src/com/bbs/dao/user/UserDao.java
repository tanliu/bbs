package com.bbs.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bbs.entity.user.User;
import com.bbs.services.user.UserServices;
import com.bbs.utils.DataBaseUtils;

public class UserDao {
	 private ResultSet rs=null;
	 DataBaseUtils dbu=new DataBaseUtils();
	/**
	 * 方法描述:登录验证 
	 */
	public boolean CheckLogin(String username,String password){
        
        String sql="select username,password from user1 where username=? and password=?";
      //MD5密码加密
      	UserServices US=new UserServices();
      	String passwordMD=US.MD5(password);
        String[] parameters={username,passwordMD};
	     rs=dbu.query(sql, parameters);
	     try {
			while(rs.next())
			 try {
				if(username.equals(rs.getString("username"))&& passwordMD.equals(rs.getString("password"))){
					 return true;
				 }else 
					 return false; 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dbu.closeAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * 方法描述:将注册信息添加进数据库
	 * @param username
	 * @param password
	 * @param Email
	 * @return
	 */
	public void RegisterInformation(String id,String username,String password,int level,String email,Date time){
		String sql="insert into user1 (id,username,password,level,email,time) values(?,?,?,?,?,?)";
		String lev=String.valueOf(level);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String t = df.format(new Date()); 
		//MD5密码加密
		UserServices US=new UserServices();
		String passwordMD=US.MD5(password);
		String[] parameters={id,username,passwordMD,lev,email,t};
		dbu.save(sql, parameters);
	}

	
}
