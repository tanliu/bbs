/**
 * 
 */
package com.bbs.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
 * 项目名称：BBS
 * 类名称：DBHelper 
 * 类描述： 数据库连接池管理 工具类
 * 创建人：坛子
 * 创建时间：2016年3月30日 下午5:21:11
 * 修改人：TanLiu 
 * 修改时间：2016年3月30日 下午5:21:11
 * 修改备注： 
 * @version 
 */
public class DBHelper {
	
	private static DataSource dataSource;
	
	static{
		dataSource=new ComboPooledDataSource();
		
	}
	
	/**
	 * 方法描述:获取取一个连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("获取连接出错！");
			e.printStackTrace();
		}
		return connection;
	}
	

}
