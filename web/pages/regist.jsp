<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
</head>
<body>
<center>
    <h2>注册页面</h2>
    <form action="/regist" method="post">
        <p>用户名:<input type="text" name="user.username"></p>
        <p>密码:<input type="password" name="user.userpassword"/></p>
        <p><input type="submit" value="注册" /></p>
    </form>
</center>
</body>
</html>