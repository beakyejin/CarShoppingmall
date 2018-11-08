<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hk.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CompanyVO> list = (ArrayList<CompanyVO>)request.getAttribute("list"); %>
<%if(list!=null && list.size()>0){ %>
<p>회사별 차량 판매 대수</p>
<table>
	<tr>
		<th>회사 이름</th>
		<th>판매 대수</th>		
	</tr>
	<%for(CompanyVO vo: list){ %>
	<tr>
		<td><%=vo.getCom_name() %></td>
		<td><%=vo.getCom_amount() %> 대</td>
	</tr>
	<%} %>
</table>
<br>
<p>회사별 차량 총판매 수익</p>
<table>
	<tr>
		<th>회사 이름</th>
		<th>총판매 수익</th>		
	</tr>
	<%for(CompanyVO vo: list){ %>
	<tr>
		<td><%=vo.getCom_name() %></td>
		<td><%=vo.getCom_total() %> 만원</td>
	</tr>
	<%} %>
</table>
<%} %>