
package com.chainsys.carsaleapp.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.dao.impl.CarOwnerImp;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarOwnerService;
import com.chainsys.carsaleapp.util.DbException;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired
    CarOwnerService coii;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		 CarOwner cor=new CarOwner();
    		long phNo=Long.parseLong(request.getParameter("contactNo"));
    		cor.setContactNo(phNo);
    		String sname=request.getParameter("sname");
    		cor.setOwnerName(sname);
    		String  streetName=request.getParameter("address1");
    		cor.setAddress1(streetName);
    		String  doorName=request.getParameter("doorno");
    		cor.setAddress2(doorName);
    		String  city=request.getParameter("city");
    		cor.setCity(city);
            String state=request.getParameter("state");
            cor.setState(state);
            int pincode=Integer.parseInt(request.getParameter("pincode"));
    		cor.setPincode(pincode);
            String pass=request.getParameter("npass");
    	   cor.setPassword(pass);
           	
				
				try {
				   coii.addCarOwner(cor);
					RequestDispatcher  dispatcher=request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("register.jsp?errorMessage=Register failed!!!");
					
				}
			}
	
	}

