package com.alpha.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session !=  null && session.getAttribute("isCustomer")!=null) {
			req.getRequestDispatcher("customerhome.html").forward(req, resp);
		}else {
			req.getRequestDispatcher("customerlogin.html").forward(req, resp);
		}
	}
}
