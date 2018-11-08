package kr.co.hk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modCar")
public class ModCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------modCar [get]------------");
		
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		System.out.println("c_no: " + c_no);
		
		CarVO vo = CarDAO.getCarDetail(c_no);
		request.setAttribute("vo", vo);
		
		request.setAttribute("target", "modCar");
		request.setAttribute("title", "정보 수정");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------modCar [post]------------");
		
		request.setCharacterEncoding("UTF-8");
		
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_regdate = request.getParameter("c_regdate");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int c_cc = Integer.parseInt(request.getParameter("c_cc"));
		
		CarVO vo = new CarVO();
		vo.setC_no(c_no);
		vo.setC_name(c_name);
		vo.setC_type(c_type);
		vo.setC_regdate(c_regdate);
		vo.setC_price(c_price);
		vo.setC_cc(c_cc);
		
		CarDAO.updateCar(vo);
		response.sendRedirect("carDetail?c_no="+c_no);
		
	}

}
