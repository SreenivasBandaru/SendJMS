<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>sendMessage</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body bgcolor="aqua" >
<table border="0" cellpadding="0" cellspacing="0" width="100%" >
      <tr>
        <!-- <td bgcolor="ffffff" width="10"><img border="0" src="images/1x1_trans.gif" width="10" height="1" alt=""></td> -->
        <td bgcolor="ffffff" width="100%" background="images/1x1_trans.gif" ><img border="0" src="images/eidiko_logo.jpg" width="300" height="85" alt="EIDIKO"></td>
      </tr>
    </table>
    <h1 align="center"> Send Message Via JMS</h1>
<form action="<%= request.getContextPath()  %>/PutJmsMessageServlet" method="post">
<table  align="center">
	<tbody>
		<tr>
			<td>Queue Name</td>
			<td> <input type="text" name="queueName" size="20" value="jms/eidikoInQueue"></td>
			<!-- <td> (java:comp/env/jms/PackageReceivedQueue)</td>  -->
		</tr>
		<tr>
			<td>Queue Connection Factory Name</td>
			<td><input type="text" name="qCFName" size="20" value="jms/bus2"></td>
			<!--<td> (java:comp/env/jms/TheConnectionFactory)</td>-->
		</tr>
		<tr>
			<td>Message</td>
			<td colspan="2"><textarea rows="4" cols="30" name="message"></textarea></td>
		</tr>
		<tr>
			<td align="center" colspan="3"><input type="submit" name="submit" value="Submit"></td>
			
		</tr>
	</tbody>
</table>
	<%	String resultMessage = request.getParameter("result");
	if(resultMessage != null ) {
 %>
 <h3 align="center"><font color="red"><%= resultMessage %></font></h3>
 <% } %>
</form>
</body>
</html>