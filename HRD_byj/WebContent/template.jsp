<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="common.css">
<title>${title}</title>
</head>
<body>
	<div class="container">
		<jsp:include page="top.jsp" />
		<div class="section">
			<jsp:include page="${target}.jsp" />
		</div>
		<jsp:include page="bottom.jsp" />
	</div>
</body>
</html>