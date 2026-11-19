package com.alpha.Admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long mobile = 1234567890;
		String password = "Allen@123";

		long mobno = Long.parseLong(req.getParameter("mobile"));
		String pass = req.getParameter("password");
		
		try {
			if(mobno==mobile && pass.equals(password)) {
				HttpSession session = req.getSession(true);
				session.setAttribute("isAdmin", true);

                
				req.getRequestDispatcher("adminhome.html").forward(req, resp);
			}
			else {
				resp.getWriter().print("<h1> INVALID CREDENTIALS</h1>");
			}

		}catch (Exception e) {
			resp.getWriter().print("<h1> INVALID CREDENTIALS</h1>");
		}
	}
}
