<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("jsp/login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Login Successful 🎉</h2>
<p>User ID: <%= userId %></p>

<a href="jsp/login.jsp">Logout (manual)</a>

</body>
</html>
