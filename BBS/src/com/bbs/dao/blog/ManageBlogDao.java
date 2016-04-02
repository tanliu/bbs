/**
 * 
 */
package com.bbs.dao.blog;

import java.io.Serializable;

import com.bbs.entity.blog.Blog;
import com.bbs.utils.PageUtils;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�ManageBlogDao 
 * �������� ��������ģ��Dao��ӿ�
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��2�� ����4:34:26
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��2�� ����4:34:26
 * �޸ı�ע�� 
 * @version 
 */
public interface ManageBlogDao {
	
	/**
	 * ��������:ɾ������
	 */
	public void deleteBlog(Serializable id);
	/**
	 * ��������:����һ��������
	 */
	public PageUtils<Blog> findPartBlot(PageUtils<Blog> pageUtils);
	
	/**
	 * ��������:��ȡ�����������
	 * @return
	 */
	public int getDataCount(String...condition);
	/**
	 * ����������ͨ��titil��ѯ��
	 * @param pageUtils
	 * @param query
	 * @return
	 */
	public PageUtils<Blog> findByTitle(PageUtils<Blog> pageUtils, String query);

}
