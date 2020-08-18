<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String msg = "2";
System.out.println(msg);
request.setAttribute("message", msg);
System.out.println(request.getAttribute("message"));

%>
<body>

</body>
</html>