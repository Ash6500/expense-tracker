<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>User Login</h2>

<form action="<%=request.getContextPath()%>/login" method="post">
    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>
</form>

<% if (request.getParameter("error") != null) { %>
    <p style="color:red;">Invalid email or password</p>
<% } %>

</body>
</html>
