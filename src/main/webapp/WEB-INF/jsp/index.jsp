<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" id="login" action="PlayHere">
<table>
<tr>
<td><select id="names" name="names">
<%
String[] names = { "Surendra","Ghaith","James","Mario" };
for(int i=0;i<4;i++){%>
<option value="<%=i%>"><%= names[i]%></option>
<%	
}
%>
</select> </td>
<td><input type="submit" value="Go"> </td>
</tr>
</table>
</form>

</body>
</html>