<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hk.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CarVO> list = (ArrayList<CarVO>)request.getAttribute("carList");
%>
<script type="text/javascript"> 
	function clkBtn() {
		location.href="inputCar";
	}

</script>
<div class="tbl_mall">
	<%if(list!=null && list.size()>0){ %>
	<table>
		<tr>
			<th>등록 번호</th>
			<th>차량 이름</th>
			<th>출시 일자</th>
			<th>차량 가격</th>
		</tr>
		<%for(CarVO vo: list){ %>
		<tr>
			<td><%=vo.getC_no() %></td>
			<td><a href="carDetail?c_no=<%=vo.getC_no() %>"><%=vo.getC_name() %></a></td>
			<td><%=vo.getC_regdate() %></td>
			<td><%=vo.getC_price() %>만원</td>
		</tr>
		<%} %>
	</table>
	<%} else{%>	
		등록된 차량이 없습니다!	
	<%} %>
</div>
<div class="btn_div">
	<div class="btn">
		<a href="javascript: clkBtn();">차량 등록</a>
	</div>
</div>
