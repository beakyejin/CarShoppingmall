package kr.co.hk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputCom")
public class InputComServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------inputCom [get]------------");
		
		int comMaxNo = CarDAO.getComMaxNo();
		request.setAttribute("comMaxNo", comMaxNo);
		
		request.setAttribute("target", "inputCom");
		request.setAttribute("title", "회사 등록");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------inputCom [post]------------");
		
		request.setCharacterEncoding("UTF-8");
		
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		String com_name = request.getParameter("com_name");
		String com_addr = request.getParameter("com_addr");
		
		System.out.println("com_no : " + com_no);
		System.out.println("com_name : " + com_name);
		System.out.println("com_addr : " + com_addr);
		
		CompanyVO vo = new CompanyVO();
		vo.setCom_no(com_no);
		vo.setCom_name(com_name);
		vo.setCom_addr(com_addr);
		
		CarDAO.insertCom(vo);
		
		response.sendRedirect("inputCar");
	}

}
