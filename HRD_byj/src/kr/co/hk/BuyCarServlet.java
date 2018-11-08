package kr.co.hk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buyCar")
public class BuyCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------buyCar [get]------------");
		
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		System.out.println("c_price: " + c_price);
		System.out.println("com_no: " + com_no);
		
		CarDAO.updateCompany(c_price, com_no);
		
		response.sendRedirect("carMall");
	}

}
