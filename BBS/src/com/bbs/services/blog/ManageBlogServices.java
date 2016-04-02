package com.bbs.services.blog;

import java.io.Serializable;

import com.bbs.entity.blog.Blog;
import com.bbs.utils.PageUtils;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�ManageBlogServices 
 * �������� ��������ģ��ҵ������
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��2�� ����4:23:44
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��2�� ����4:23:44
 * �޸ı�ע�� 
 * @version 
 */ 
public interface ManageBlogServices {
	
	/**
	 * ��������:ɾ������
	 */
	public void deleteBlog(Serializable id);
	/**
	 * ��������:����һ��������
	 */
	public PageUtils<Blog> findPartBlot(PageUtils<Blog> pageUtils);
	
	/**
	 * ��������:ͨ��titles��ѯ
	 * @param pageUtils
	 * @param query
	 * @return
	 */
	public PageUtils<Blog> findByTitle(PageUtils<Blog> pageUtils, String query);

}
