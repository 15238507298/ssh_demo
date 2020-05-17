<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<center>
    <h3>登录页面</h3>
    <form action="/login" method="post">
        用户名:<input type="text" name="user.username" /><br>
        密码:<input type="text" name="user.userpassword" /><br>
        <input type="submit" value="登录">
    </form>
</center>
</body>
</html>