package com.bbs.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bbs.entity.user.User;
import com.bbs.utils.DataBaseUtils;

public class UserDao {
	 private ResultSet rs=null;
	/**
	 * 方法描述:登录验证 
	 */
	public boolean checklogin(String username,String password){
        DataBaseUtils dbu=new DataBaseUtils();
        String sql="select username,password from user where username=? and password=?";
	     String[] parameters={username,password};
	     rs=dbu.query(sql, parameters);
	     try {
			if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password"))){
				 return true;
			 }else 
				 return false; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
