package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputCar")
public class InputCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------inputCar [get]------------");
		
		int maxNo = CarDAO.getCarMaxNo(); 
		request.setAttribute("maxNo", maxNo);
		
		List<CompanyVO> comList = CarDAO.getComList(); 
		request.setAttribute("comList", comList);
		
		request.setAttribute("target", "inputCar");
		request.setAttribute("title", "차량 등록");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------inputCar [post]------------");
		
		request.setCharacterEncoding("UTF-8");

		int c_no = Integer.parseInt(request.getParameter("c_no"));
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_regdate = request.getParameter("c_regdate");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int c_cc = Integer.parseInt(request.getParameter("c_cc"));
		
		System.out.println("c_no : " + c_no);
		System.out.println("com_no : " + com_no);
		System.out.println("c_name : " + c_name);
		System.out.println("c_type : " + c_type);
		System.out.println("c_regdate : " + c_regdate);
		System.out.println("c_price : " + c_price);
		System.out.println("c_cc : " + c_cc);
		
		CarVO vo = new CarVO();
		vo.setC_no(c_no);
		vo.setCom_no(com_no);
		vo.setC_name(c_name);
		vo.setC_type(c_type);
		vo.setC_regdate(c_regdate);
		vo.setC_price(c_price);
		vo.setC_cc(c_cc);
		
		CarDAO.insertCar(vo);
		
		response.sendRedirect("carMall");
	}

}
