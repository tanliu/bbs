/**
 * 
 */
package com.bbs.dao.blog;

import java.io.Serializable;

import com.bbs.entity.blog.Blog;
import com.bbs.utils.PageUtils;

/** 
 * 项目名称：BBS
 * 类名称：ManageBlogDao 
 * 类描述： 管理帖子模块Dao层接口
 * 创建人：坛子
 * 创建时间：2016年4月2日 下午4:34:26
 * 修改人：TanLiu 
 * 修改时间：2016年4月2日 下午4:34:26
 * 修改备注： 
 * @version 
 */
public interface ManageBlogDao {
	
	/**
	 * 方法描述:删除帖子
	 */
	public void deleteBlog(Serializable id);
	/**
	 * 方法描述:查找一部分帖子
	 */
	public PageUtils<Blog> findPartBlot(PageUtils<Blog> pageUtils);
	
	/**
	 * 方法描述:获取表的总有数量
	 * @return
	 */
	public int getDataCount(String...condition);
	/**
	 * 方法描述：通过titil查询帖
	 * @param pageUtils
	 * @param query
	 * @return
	 */
	public PageUtils<Blog> findByTitle(PageUtils<Blog> pageUtils, String query);

}
