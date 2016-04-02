/**
 * 
 */
package com.bbs.services.blog.impl;

import java.io.Serializable;

import com.bbs.dao.blog.ManageBlogDao;
import com.bbs.dao.blog.impl.ManageBlogDaoImpl;
import com.bbs.entity.blog.Blog;
import com.bbs.services.blog.ManageBlogServices;
import com.bbs.utils.PageUtils;

/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�ManagerServicesBlogImpl 
 * �������� 
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��2�� ����4:27:33
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��2�� ����4:27:33
 * �޸ı�ע�� 
 * @version 
 */
public class ManagerServicesBlogImpl implements ManageBlogServices {
	
	ManageBlogDao managerBlogDao=new ManageBlogDaoImpl();

	@Override
	public void deleteBlog(Serializable id) {
		managerBlogDao.deleteBlog(id);
	}

	@Override
	public PageUtils<Blog> findPartBlot(PageUtils<Blog> pageUtils) {
		return managerBlogDao.findPartBlot(pageUtils);
	}

	@Override
	public PageUtils<Blog> findByTitle(PageUtils<Blog> pageUtils, String query) {
		// TODO Auto-generated method stub
		return managerBlogDao.findByTitle(pageUtils,query);
	}



}
