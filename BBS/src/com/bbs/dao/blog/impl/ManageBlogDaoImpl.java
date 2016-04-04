/**
 * 
 */
package com.bbs.dao.blog.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.dao.blog.ManageBlogDao;
import com.bbs.entity.blog.Blog;
import com.bbs.utils.DataBaseUtils;
import com.bbs.utils.PageUtils;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�ManageBlogDaoImpl 
 * �������� ��������ģ��Dao����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��2�� ����4:36:49
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��2�� ����4:36:49
 * �޸ı�ע�� 
 * @version 
 */
public class ManageBlogDaoImpl implements ManageBlogDao {
	
	DataBaseUtils dbUtils=new DataBaseUtils();

	@Override
	public void deleteBlog(Serializable id) {
		String sql="DELETE FROM public where id=?";
		String[] parameters=new String[]{(String) id};
		dbUtils.delete(sql, parameters);		
	}

	@Override
	public PageUtils<Blog> findPartBlot(PageUtils<Blog> pageUtils) {
		//�����ܹ��ж���ҳ
		pageUtils.setTotalCount(getDataCount());
		if(pageUtils.getTotalCount()==0){  //����û�м�¼ʱ
			return pageUtils;
		}
		//��������
		List<Blog> blogs=new ArrayList<Blog>();
		String sql="SELECT * from public ORDER BY time ASC LIMIT "+(pageUtils.getCurrentPage()-1)*pageUtils.getPageSize()+" , "+pageUtils.getPageSize();
		String[] parameters=null;
		ResultSet rs=dbUtils.query(sql, parameters);
		try {
			while (rs.next()) {
				Blog blog=new Blog();
				blog.setId(rs.getString("id"));
				blog.setUserId(rs.getString("title"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setTime(rs.getTimestamp("time"));
				blogs.add(blog);
			}
			pageUtils.setPageData(blogs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtils.closeAll();
		}
		
		return pageUtils;
	}

	@Override
	public int getDataCount(String...condition) {
		int row=0;
		String sql="SELECT COUNT(*) from public";
		if(condition.length>0){
			sql+=" "+condition[0];
		}
		String[] parameters=null;
		ResultSet rs=dbUtils.query(sql, parameters);
		try {
			while(rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbUtils.closeAll();
		}
		return row;
	}

	@Override
	public PageUtils<Blog> findByTitle(PageUtils<Blog> pageUtils, String query) {
		//�����ܹ��ж���ҳ
		pageUtils.setTotalCount(getDataCount("where title LIKE '%"+query+"%'"));
		if(pageUtils.getTotalCount()==0){  //����û�м�¼ʱ
			return pageUtils;
		}
		List<Blog> blogs=new ArrayList<Blog>();
		String sql="SELECT * from public where title LIKE ? ORDER BY time ASC LIMIT "+(pageUtils.getCurrentPage()-1)*pageUtils.getPageSize()+" , "+pageUtils.getPageSize();;
		String[] parameters=new String[]{"%"+query+"%"};
		ResultSet rs=dbUtils.query(sql, parameters);
		try {
			while (rs.next()) {
				Blog blog=new Blog();
				blog.setId(rs.getString("id"));
				blog.setUserId(rs.getString("title"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setTime(rs.getTimestamp("time"));
				blogs.add(blog);
			}
			pageUtils.setPageData(blogs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtils.closeAll();
		}
		return pageUtils;
	}
	

}
