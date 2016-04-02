package com.bbs.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.dao.user.UserDao;

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
			response.setContentType("text/html;charset=utf-8");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			boolean check=UD.checklogin(username,password);
			if(check){
				response.sendRedirect("");//��ת����ҳ��
			}else {
				PrintWriter out = response.getWriter();
				out.println("<HTML>");
				out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
				out.println("  <BODY>");
				out.print("��¼ʧ�ܣ����Զ���ת�ص�¼���棡 ");
				response.setHeader("refresh","2;url=login.jsp");
				out.println("  </BODY>");
				out.println("</HTML>");
			}
		}


}
