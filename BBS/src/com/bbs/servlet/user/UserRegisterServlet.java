package com.bbs.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.dao.user.UserDao;
import com.bbs.entity.user.User;
import com.bbs.services.user.UserServices;

public class UserRegisterServlet extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		UserDao UD=new UserDao();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		Date time = new Date();
		 User U=new User();
		 U.setUsername(username);
		 U.setPassword(password);
		 U.setEmail(email);
		 U.setLevel(0);
		 U.setTime(time);
		UserServices US=new UserServices();
		String Uname=US.CheckUsername(U.getUsername());
		String Pwd=US.CheckPassword(U.getPassword());
		String Email=US.CheckEmail(U.getEmail());
		
		//����session
		HttpSession session=request.getSession();
		//����ע����Ϣ��ʽ�Ƿ���ȷ����Ϣ
		session.setAttribute("Uname", Uname);
		session.setAttribute("Pwd", Pwd);
		session.setAttribute("Email", Email);
		
		//�����û�ע�����Ϣ
		session.setAttribute("Userinformation",U);
		/*
		session.setAttribute("username",U.getUsername());
		session.setAttribute("password", U.getPassword());
		session.setAttribute("id", U.getId());
		session.setAttribute("email", U.getEmail());
		session.setAttribute("time", U.getTime());*/
		
		//�ж�ע����Ϣ��ʽ��ȷ
		if(Uname.equals("true") && Pwd.equals("true") && Email.equals("true")){
			//�����ݲ������ݿ�
			UD.RegisterInformation(U.getId(),U.getUsername(),U.getPassword(),U.getLevel(),U.getEmail(),U.getTime());
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("register.jsp");
		}
	}

}
