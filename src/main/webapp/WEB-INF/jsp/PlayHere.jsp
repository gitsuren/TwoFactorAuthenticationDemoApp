<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.suru.appBean"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bull n Cow</title>
<script type="text/javascript" src="ajax.js"></script>
<script language="javascript" type="text/javascript">
   function checkWord(id,word){ 
	   debugger;
   var one=document.getElementById("one"+id).value;
  // alert(one);
   var two=document.getElementById("two"+id).value;
   //alert(two);
   var three=document.getElementById("three"+id).value;
  // alert(three);
   var four=document.getElementById("four"+id).value;
   
   var markurl="/ajaxHost?one="+one+"&two="+two+"&three="+three+"&four="+four+"&word="+word;  
   debugger;
   
   ajaxCall(markurl,id);
   }
</script>

<jsp:useBean id="word" class="com.suru.Word" scope="session"></jsp:useBean>

</head>
<body>
<table width="100%">
	<tr>
		<td width="75%" align="center">
		<table>
			<tr>
				<td>SN.</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>BULL</td>
				<td>|</td>
				<td>COW</td>
			</tr>
			<%
			if (request.getParameter("names") == null) {
			%>
			<jsp:forward page="index.jsp"></jsp:forward>

			<%
				}
				appBean appbean = new appBean();
				appbean.setId(Integer.parseInt(request.getParameter("names")));
				word.setABean(appbean);
				out.print("<h1>Hello " + appbean.getPlayer(Integer.parseInt(request.getParameter("names")))
						+ " !!!</h1>");
				word.setQuestionWord();
				String worde = word.getQuestionWord();
				System.out.println(worde);

				for (int i = 0; i < 8; i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><input maxlength="1" size="1" type="text" id="one<%=i%>"
					name="one<%=i%>"></td>
				<td><input maxlength="1" size="1" type="text" id="two<%=i%>"
					name="two<%=i%>"></td>
				<td><input maxlength="1" size="1" type="text" id="three<%=i%>"
					name="three<%=i%>"></td>
				<td><input maxlength="1" size="1" type="text" id="four<%=i%>"
					name="four<%=i%>"></td>
				<%
				if (i != 0) {
				%>
				<td><input value="ok" type="button" id="button<%=i%>"
					disabled="disabled" name="button<%=i%>"
					onclick="checkWord(<%=i %>,'word')"></td>
				<%
				} else {
				%>
				<td><input value="ok" type="button" id="button<%=i%>"
					name="button<%=i%>" onclick="checkWord(<%=i %>,'word')"></td>
				<%
				}
				%>
				<td>&nbsp;</td>
				<td>
				<div id="spell<%=i %>">&nbsp;</div>
				</td>
				<td>&nbsp;</td>
				<td>
				<div id="bull<%=i %>">&nbsp;</div>
				</td>
				<td>|</td>
				<td>
				<div id="cow<%=i %>">&nbsp;</div>
				</td>
			</tr>

			<%
			}
			%>

		</table>
		</td>
		<td width="25%" align="right">
		<table>
			<tr>
				<td>Name</td>
				<td>Games</td>
			</tr>
			<%
					for (int i = 0; i < 4; i++) {
					out.print("<tr><td>" + appbean.getPlayer(i) + "</td><td>"
					+ appbean.getScore(i) + "</td></tr>");
				}
			%>
		</table>
		</td>
	</tr>
</table>
</body>
</html>