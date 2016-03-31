/**
 * 
 */
package com.bbs.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�DBHelper 
 * �������� ���ݿ����ӳع��� ������
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��30�� ����5:21:11
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��30�� ����5:21:11
 * �޸ı�ע�� 
 * @version 
 */
public class DBHelper {
	
	private static DataSource dataSource;
	
	static{
		dataSource=new ComboPooledDataSource();
		
	}
	
	/**
	 * ��������:��ȡȡһ������
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("��ȡ���ӳ���");
			e.printStackTrace();
		}
		return connection;
	}
	

}
