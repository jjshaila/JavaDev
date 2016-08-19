package com.java.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XMLServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 System.out.println("In XML Servlet");
		 String userName = request.getParameter("userName");
		// System.out.println("Hello "+userName);
		 PrintWriter out = response.getWriter();
		 out.println("Hi !!"+userName);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("In Post method Servlet");
		 String userName = request.getParameter("userName");
		 String fullName = request.getParameter("fullName");
		 String prof = request.getParameter("prof");
		 String[] location = request.getParameterValues("loc");
		 int size =location.length;
		 PrintWriter out = response.getWriter();
		 out.println("Hi I known your name "+userName+"Full Name"+fullName+"Your Profession"+prof+"Your at "+location.length+"location");
		 for(int i=0;i<location.length;i++){
			 out.println(location[i]);
			 
		 }
		 ServletContext context = request.getServletContext();
		 HttpSession session = request.getSession();
		 if(userName!= "" && userName!= null){
			 session.setAttribute("saved user name", userName);
			 context.setAttribute("Saved user name", userName);
		 }
		 System.out.println("Saved user name in session"+(String)session.getAttribute("saved user name"));
		 System.out.println("Saved user name in Context"+(String)context.getAttribute("saved user name"));
			
	}
}
