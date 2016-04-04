package com.bbs.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.dao.user.UserDao;
import com.bbs.entity.user.User;

public class UserloginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    UserDao UD=new UserDao();
		    User U=new User();
			response.setContentType("text/html;charset=utf-8");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			U.setUsername(username);
			U.setPassword(password);
			boolean check=UD.CheckLogin(U.getUsername(),U.getPassword());
			if(check){
				response.sendRedirect("success.jsp");//跳转至主页面
			}else {
				response.setHeader("refresh","2;url=login.jsp");
			}
		}


}
