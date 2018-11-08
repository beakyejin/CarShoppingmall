<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function clkSubmit() {
		var frm = document.frm;
		
		if(frm.com_no.value == ""){
			alert("회사 번호를 입력해 주세요.");
			return false;
		}else if(frm.com_name.value == ""){
			alert("회사 이름을 입력해 주세요.");
			return false;
		}else if(frm.com_addr.value == ""){
			alert("회사 주소를 입력해 주세요.");
			return false;
		}
		return true;
	}
</script>
<form  action="inputCom" method="post" name="frm" onsubmit="return clkSubmit()">
	<table>
		<tr>
			<th>회사 번호</th>
			<td><input type="text" name="com_no" value="${comMaxNo}"> </td>
		</tr>
		<tr>
			<th>회사 이름</th>
			<td><input type="text" name="com_name"> </td>
		</tr>
		<tr>
			<th>회사 주소</th>
			<td><input type="text" name="com_addr"> </td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회사 등록"> </td>
		</tr>
	</table>
</form>