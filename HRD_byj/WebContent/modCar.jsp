<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="frm" action="modCar" method="post">
	<input type="hidden" name="c_no" value="${vo.c_no }">
	<table>
		<tr>
			<th>차량 이름</th>
			<td>
				<input type="text" name="c_name" value="${vo.c_name}">
			</td>
		</tr>
		<tr>
			<th>차종</th>
			<td>
				<input type="text" name="c_type" value="${vo.c_type}">
			</td>
		</tr>
		<tr>
			<th>출시 일자</th>
			<td>
				<input type="date" name="c_regdate" value="${vo.c_regdate}">
			</td>
		</tr>
		<tr>
			<th>차량 가격</th>
			<td>
				<input type="text" name="c_price" value="${vo.c_price}0000">
			</td>
		</tr>
		<tr>
			<th>배기량</th>
			<td>
				<input type="text" name="c_cc" value="${vo.c_cc}">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="정보 수정">
			</td>
		</tr>
	</table>
</form>