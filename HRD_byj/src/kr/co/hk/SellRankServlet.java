package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sellRank")
public class SellRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------sellRank [get]------------");
		
		List<CompanyVO> list = CarDAO.getComAllSell(); 
		request.setAttribute("list", list);
		
		request.setAttribute("target", "sellRank");
		request.setAttribute("title", "판매 순위");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
	}

}
