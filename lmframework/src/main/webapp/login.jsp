<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Login Page</title>
	</head>
	<body onload='document.f.j_username.focus();'>
		<h3>
			Login with Username and Password
		</h3>
		<form name='f'
			action='<%=request.getContextPath()%>/j_spring_security_check'
			method='POST'>
			<table>
				<tr>
					<td>
						User:
					</td>
					<td>
						<input type='text' name='j_username' value=''>
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type='password' name='j_password' />
					</td>
				</tr>
				<tr>
					<td>
						<input type='checkbox' name='_spring_security_remember_me' />
					</td>
					<td>
						Remember me on this computer.
					</td>
				</tr>
				<tr>
					<td colspan='2'>
						<input name="submit" type="submit" value="Login" />
					</td>
				</tr>
			</table>
		</form>
		<%
			if ("true".equals(request.getParameter("error"))) {
		%>
		<hr/>
		<h3><p style="color:red">login error</p></h3>
		<%
			}
		%>
	</body>
</html>