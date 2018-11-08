package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carMall")
public class CarMallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------carMall [get]------------");
		
		List<CarVO> carList = CarDAO.getCarList();
		request.setAttribute("carList", carList);
		
		request.setAttribute("target", "carMall");
		request.setAttribute("title", "자동차 몰");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
	}
	
}
