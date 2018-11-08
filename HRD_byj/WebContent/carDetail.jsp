<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function clkBuy(c_price, com_no) {
		location.href="buyCar?c_price="+c_price +"&com_no=" + com_no;
	}
	
	function clkMod(c_no) {
		location.href="modCar?c_no="+c_no;
	}
</script>
<table>
	<tr>
		<th>차량 회사</th>
		<td>${vo.com_name }</td>
	</tr>
	<tr>
		<th>차량 이름</th>
		<td>${vo.c_name }</td>
	</tr>
	<tr>
		<th>차종</th>
		<td>${vo.c_type }</td>
	</tr>
	<tr>
		<th>출시 일자</th>
		<td>${vo.c_regdate }</td>
	</tr>
	<tr>
		<th>차량 가격</th>
		<td>${vo.c_price }만원</td>
	</tr>
	<tr>
		<th>배기량</th>
		<td>${vo.c_cc } CC</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="차량 구매" onclick="clkBuy(${vo.c_price }, ${vo.com_no})">
		</td>
	</tr>
</table>
<input type="button" value="정보 수정" onclick="clkMod(${vo.c_no})">