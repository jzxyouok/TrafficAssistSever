package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class RegisterLet extends HttpServlet {

	private static final long serialVersionUID = 5938027346777323900L;
	private static final String SUCCESS = "true";
	private static final String FAIL = "false";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收客户端信息
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password");
		System.out.println(username + "--" + password);
		// 新建服务对象
		Service serv = new Service();
		// 验证处理
		boolean reged = serv.Register(username, password);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (reged) {
			System.out.print("Register Succss");
			//request.getSession().setAttribute("username", username);
			// 返回信息到客户端
			out.print(SUCCESS);
			// response.sendRedirect("welcome.jsp");
		} else {
			System.out.print("Register Failed");
			out.print(FAIL);
		}
		out.flush();
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收客户端信息
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password");
		System.out.println(username + "--" + password);
		// 新建服务对象
		Service serv = new Service();
		// 验证处理
		boolean reged = serv.Register(username, password);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (reged) {
			System.out.print("Register Succss Post");
			request.getSession().setAttribute("username", username);
			// 返回信息到客户端
			out.print(SUCCESS);
			// response.sendRedirect("welcome.jsp");
		} else {
			System.out.print("Register Failed");
			out.print(FAIL);
		}
		out.flush();
		out.close();
	}
}