package com.bbs.servlet.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.blog.Blog;
import com.bbs.services.blog.ManageBlogServices;
import com.bbs.services.blog.impl.ManagerServicesBlogImpl;
import com.bbs.utils.PageUtils;

/** 
 * 项目名称：BBS
 * 类名称：ManagerBlogServlet 
 * 类描述： 管理帖子Servlet层
 * 创建人：坛子
 * 创建时间：2016年4月2日 下午9:49:44
 * 修改人：TanLiu 
 * 修改时间：2016年4月2日 下午9:49:44
 * 修改备注： 
 * @version 
 */ 
public class ManagerBlogServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodName=request.getParameter("method");
		

		if(methodName!=null&&!methodName.equals("")){
			try {
				//通过反射调用相应的方法
				this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class).invoke(this, request,response);
			} catch (Exception e) {//返回找不到界面
				
				e.printStackTrace();
			}
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}
	
	/**
	 * 方法描述:处理列表的界面
	 * @param request
	 * @param response
	 */
	public void listUI(HttpServletRequest request, HttpServletResponse response){
		
		ManageBlogServices mBlogServices=new ManagerServicesBlogImpl();
		PageUtils<Blog> pageUtils=new PageUtils<Blog>();

		String currentPage=request.getParameter("currentPage");
		String query=request.getParameter("query");
		if(currentPage!=null&&!currentPage.equals("")){
			pageUtils.setCurrentPage(Integer.parseInt(currentPage));
		}
		if(query==null||"".equals(query)){
			pageUtils=mBlogServices.findPartBlot(pageUtils);
		}else{
			try {
				query= new String(query.getBytes("ISO-8859-1"),"utf-8") ;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			pageUtils=mBlogServices.findByTitle(pageUtils,query);
			request.setAttribute("query", query);
		}
		
		
		request.setAttribute("pagetUtils", pageUtils);
		
		System.out.println(pageUtils.getCurrentPage()+"---------------------------------");
		
		try {
			request.getRequestDispatcher("WEB-INF/blog/blogmanager.jsp").forward(request, response);
		}catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 方法描述:删除帖子
	 * @param request
	 * @param response
	 */
	public void delete(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		ManageBlogServices mBlogServices=new ManagerServicesBlogImpl();
		mBlogServices.deleteBlog(id);
		try {
			request.getRequestDispatcher("ManagerBlogServlet?method=listUI").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAll(HttpServletRequest request,HttpServletResponse response){
		String[] ids=request.getParameterValues("ids");
		ManageBlogServices mBlogServices=new ManagerServicesBlogImpl();
		for (String id : ids) {
			mBlogServices.deleteBlog(id);
		}		
		try {
			request.getRequestDispatcher("ManagerBlogServlet?method=listUI").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
