/**
 * 
 */
package com.bbs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * 项目名称：BBS
 * 类名称：DataBaseUtils 
 * 类描述： 操作数据库的工具类
 * 创建人：坛子
 * 创建时间：2016年3月31日 上午7:57:20
 * 修改人：TanLiu 
 * 修改时间：2016年3月31日 上午7:57:20
 * 修改备注： 
 * @version 
 */
public class DataBaseUtils {

    private PreparedStatement ps = null;  
    private ResultSet rs=null;   
    private Connection con=null;

    /** 
     *作用：对数据的查询操作 
     * @param sql 
     * @param parameters 
     * @return 返回一个数据集rs 
     */  
    public ResultSet query(String sql,String[] parameters){ 
        con=DBHelper.getConnection();   //从连接池中获取连接
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
     *作用：用于对数据库的更新操作 
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
     * 方法描述:保存操作
     * @param sql insert的sql语句
     * @param parameters 对应？的数组
     */
    public void save(String sql,String[] parameters){
    	this.update(sql, parameters);
    }
    
    /**
     * 方法描述:删除操作
     * @param sql 删除语句
     * @param parameters 对应？的数组
     */
    public boolean delete(String sql,String[] parameters){
        int row=this.update(sql, parameters);  
    	if(row>0){
    		return true;
    	}    	
        return false;  
    }
    
    
   
    
      
    /** 
     *作用：对数库操作的关闭 
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
