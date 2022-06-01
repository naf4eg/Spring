<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>My Company Home Page</title>
</head>

<body>
	<h2>My Company Home Page</h2>
	<hr>
	
	<p>Welcome to the company home page!</p>

	<hr>
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<hr>
	<a href="${pageContext.request.contextPath}/admins">Access on Admin</a>
				(Welcome to Admin panel)
	<hr>
	<a href="${pageContext.request.contextPath}/managers">Access on Manager</a>
	(Welcome to Manager panel)
	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>

</html>