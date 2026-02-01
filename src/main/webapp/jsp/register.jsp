<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>User Registration</h2>

<form action="<%=request.getContextPath()%>/register" method="post">
    <label>Full Name:</label><br>
    <input type="text" name="name" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>

<% if (request.getParameter("error") != null) { %>
    <p style="color:red;">Registration failed</p>
<% } %>

</body>
</html>
