package com.alpha.Customer;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customerhome")
public class CustomerHome extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long mobno = Long.parseLong(req.getParameter("mobile"));
		String pass = req.getParameter("password");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		String query = "SELECT c FROM Customer c WHERE c.mobile=:mob";

		try {
			Customer c = (Customer) em.createQuery(query).setParameter("mob", mobno).getSingleResult();
			if (c != null && pass.equals(c.getPassword())) {
//				req.getRequestDispatcher("customerhome.html").forward(req, resp);

				HttpSession session = req.getSession(true);
				session.setAttribute("isCustomer", true);
				resp.sendRedirect("customerlogin");
			} else {
				resp.getWriter().print("<h1>INVALID CREDENTIALS</h1>");
			}
		} catch (Exception e) {
			resp.getWriter().print("<h1>NO DATA FOUND</h1>");
		}
		et.commit();

	}

}
