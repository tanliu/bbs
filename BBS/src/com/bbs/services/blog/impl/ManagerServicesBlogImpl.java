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
 * 项目名称：BBS
 * 类名称：ManagerServicesBlogImpl 
 * 类描述： 
 * 创建人：坛子
 * 创建时间：2016年4月2日 下午4:27:33
 * 修改人：TanLiu 
 * 修改时间：2016年4月2日 下午4:27:33
 * 修改备注： 
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
