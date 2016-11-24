<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
<%@ page import="com.app.controller.MainController"%>
<%
String text = MainController.htmlText;
%>

<html>
	<head>
		<meta charset="UTF-8" http-equiv="refresh"/>
	</head>
	<body>
<p><%=text%></p>
	</body>
</html>