package com.alpha.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registernewcar")
public class RegisterNewCar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caRregistrationNo = req.getParameter("regno");
		String carBrand = req.getParameter("brand");
		String carColor = req.getParameter("color");
		int carSeatingcapacity = Integer.parseInt(req.getParameter("seatingcapacity"));
		double carPriceperday = Double.parseDouble(req.getParameter("price"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Car c = new Car(caRregistrationNo, carBrand, carColor, carSeatingcapacity, carPriceperday);
		em.persist(c);
		
		et.commit();
		
		PrintWriter pw = resp.getWriter();
		pw.print("CAR REGISTERED SUCCESSFULLY");
		
	}
}
