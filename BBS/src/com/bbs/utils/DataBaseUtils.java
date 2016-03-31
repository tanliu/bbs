/**
 * 
 */
package com.bbs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�DataBaseUtils 
 * �������� �������ݿ�Ĺ�����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��31�� ����7:57:20
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��31�� ����7:57:20
 * �޸ı�ע�� 
 * @version 
 */
public class DataBaseUtils {

    private PreparedStatement ps = null;  
    private ResultSet rs=null;   
    private Connection con=null;

    /** 
     *���ã������ݵĲ�ѯ���� 
     * @param sql 
     * @param parameters 
     * @return ����һ�����ݼ�rs 
     */  
    public ResultSet query(String sql,String[] parameters){ 
        con=DBHelper.getConnection();   //�����ӳ��л�ȡ����
        try {  
            ps=con.prepareStatement(sql);  
            if(parameters!=null&&parameters.length>0){  
                for(int i=0;i<parameters.length;i++){  
                    ps.setString(i+1, parameters[i]);  
                }  
            }  
            rs=ps.executeQuery();  
        } catch (SQLException e) {               
            e.printStackTrace();  
        }
        return rs;  
    }  
      
    /** 
     *���ã����ڶ����ݿ�ĸ��²��� 
     * @param sql 
     * @param parameters 
     * @return row 
     */  
    public int update(String sql,String[] parameters){  
        int row=0;  
        con=DBHelper.getConnection();
        try {  
            ps=con.prepareStatement(sql);  
            if(parameters!=null&&parameters.length>0){  
                for(int i=0;i<parameters.length;i++){  
                    ps.setString(i+1, parameters[i]);  
                }  
            }  
            row=ps.executeUpdate();  
        } catch (SQLException e) {  
              
            e.printStackTrace();  
        }finally{  
            this.closeAll();  
        }  
        return row;  
    }  
    
    /**
     * ��������:�������
     * @param sql insert��sql���
     * @param parameters ��Ӧ��������
     */
    public void save(String sql,String[] parameters){
    	this.update(sql, parameters);
    }
    
    /**
     * ��������:ɾ������
     * @param sql ɾ�����
     * @param parameters ��Ӧ��������
     */
    public boolean delete(String sql,String[] parameters){
        int row=this.update(sql, parameters);  
    	if(row>0){
    		return true;
    	}    	
        return false;  
    }
    
    
   
    
      
    /** 
     *���ã�����������Ĺر� 
     */  
    public void closeAll(){  
          
            try {  
                if(rs!=null){  
                rs.close();  
                }  
                if(ps!=null){  
                    ps.close();  
                }  
                if(con!=null){  
                    con.close();  
                }  
            } catch (SQLException e) {                
                e.printStackTrace();  
            }  
    }  
	
}
