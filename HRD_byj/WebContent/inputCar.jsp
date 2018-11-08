<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hk.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CompanyVO> comList = (ArrayList<CompanyVO>)request.getAttribute("comList"); %>
<script type="text/javascript">
	function clkSubmit() {
		var frm = document.frm;
		
		if(frm.c_no.value ==""){
			alert("등록번호를 입력해 주세요!");
			return false;
		}else if(frm.c_name.value == ""){
			alert("차량이름를 입력해 주세요!");
			return false;
		}else if(frm.c_regdate.value == ""){
			alert("출시일자를 입력해 주세요!");
			return false;
		}else if(frm.c_price.value == ""){
			alert("차량가격을 입력해 주세요!");
			return false;
		}else if(frm.c_cc.value == ""){
			alert("배기량을 입력해 주세요!");
			return false;
		}
		return true;
	}
	
	function clkNewCom() {
		location.href="inputCom"
	}
</script>
<form action="inputCar" method="post" onsubmit="return clkSubmit()" name="frm">
	<table>
		<tr>
			<th colspan="2">원하는 차량회사가 없으면 회사 등록을 먼저 해주세요.</th>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="회사 등록" onclick="clkNewCom()">
			</td>
		</tr>
		<tr>
			<th>등록번호</th>
			<td><input type="text" name="c_no" value="${maxNo}"></td>
		</tr>
		<tr>
			<th>차량회사</th>
			<td>
				<select name="com_no">
				<%if(comList !=null && comList.size()>0){
					for(CompanyVO vo : comList){%>
					<option value="<%=vo.getCom_no()%>"><%=vo.getCom_name() %></option>
					<%}
					}%>
				</select>
			</td>
		</tr>
		<tr>
			<th>차량 이름</th>
			<td><input type="text" name="c_name"></td>
		</tr>
		<tr>
			<th>차  종</th>
			<td><select name="c_type">
				<option value="승용차">승용차</option>
				<option value="SUV">SUV</option>
			</select></td>
		</tr>
		<tr>
			<th>출시 일자</th>
			<td><input type="date" name="c_regdate"></td>
		</tr>
		<tr>
			<th>차량 가격</th>
			<td><input type="text" name="c_price"></td>
		</tr>
		<tr>
			<th>배기량</th>
			<td><input type="text" name="c_cc"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="차량 등록">
			</td>
		</tr>
	</table>
</form>