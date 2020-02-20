package com.chainsys.carsale.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.carsale.dao.impl.CarDetailImp;
import com.chainsys.carsale.model.CarDetail;
import com.chainsys.carsale.util.DbException;

/**
 * Servlet implementation class CarRegNoValidateServlet
 */
@WebServlet("/CarRegNoValidateServlet")
public class CarRegNoValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDetailImp coi=new CarDetailImp();
		CarDetail cd=new CarDetail();
		String regNo=request.getParameter("regNo");
		cd.setRegistrationNo(regNo);
		Integer alreadyRegistered=0;
		
			try {
				boolean exists=coi.isCarAlreadyRegistered(regNo);
				if(exists)
				{
					alreadyRegistered=1;
				}
				System.out.println(exists);
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.println(alreadyRegistered);
			out.flush();
	
	}
}