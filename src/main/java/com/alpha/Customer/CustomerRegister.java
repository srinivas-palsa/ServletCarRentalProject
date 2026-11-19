package com.alpha.Customer;

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

@WebServlet("/registercustomer")
public class CustomerRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		et.begin();
		
		Customer c = new Customer(name,mobile,email,password);
		em.persist(c);
		
		et.commit();
		
		req.getRequestDispatcher("customerlogin.html").forward(req, resp);
		
	}
}
