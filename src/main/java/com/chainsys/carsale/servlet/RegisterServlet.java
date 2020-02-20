
package com.chainsys.carsale.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.carsale.dao.impl.CarOwnerImp;
import com.chainsys.carsale.model.CarOwner;
import com.chainsys.carsale.util.DbException;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		 CarOwner coo=new CarOwner();
    		long phNo=Long.parseLong(request.getParameter("contactNo"));
    		coo.setContactNo(phNo);
    		String sname=request.getParameter("sname");
    		coo.setownerName(sname);
    		String  streetName=request.getParameter("address1");
    		coo.setAddress1(streetName);
    		String  doorName=request.getParameter("doorno");
    		coo.setAddress2(doorName);
    		String  city=request.getParameter("city");
    		coo.setCity(city);
            String state=request.getParameter("state");
            coo.setState(state);
            int pincode=Integer.parseInt(request.getParameter("pincode"));
    		coo.setPincode(pincode);
            String pass=request.getParameter("npass");
    	   coo.setPassword(pass);
           	
				CarOwnerImp coii=new CarOwnerImp();
				try {
				   coii.addCarOwner(coo);
					RequestDispatcher  dispatcher=request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
			
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("register.jsp?errorMessage=Register failed!!!");
					
				}
			}
	
	}


