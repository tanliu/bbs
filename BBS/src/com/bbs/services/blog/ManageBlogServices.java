package com.bbs.services.blog;

import java.io.Serializable;

import com.bbs.entity.blog.Blog;
import com.bbs.utils.PageUtils;

/** 
 * 项目名称：BBS
 * 类名称：ManageBlogServices 
 * 类描述： 管理帖子模块业务处理类
 * 创建人：坛子
 * 创建时间：2016年4月2日 下午4:23:44
 * 修改人：TanLiu 
 * 修改时间：2016年4月2日 下午4:23:44
 * 修改备注： 
 * @version 
 */ 
public interface ManageBlogServices {
	
	/**
	 * 方法描述:删除帖子
	 */
	public void deleteBlog(Serializable id);
	/**
	 * 方法描述:查找一部分帖子
	 */
	public PageUtils<Blog> findPartBlot(PageUtils<Blog> pageUtils);
	
	/**
	 * 方法描述:通过titles查询
	 * @param pageUtils
	 * @param query
	 * @return
	 */
	public PageUtils<Blog> findByTitle(PageUtils<Blog> pageUtils, String query);

}
