<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Yahoo!!</title>
</head>
<body>
    <h1 style="font-size: large;">Login Form</h1>
    <form action="/studentsearch.do" method="GET">
        Name : <input name="username" type="text"/>
        <br/>
        Password : <input name="password" type="password"/><br>
        <button type="submit">Login</button>

    </form>   
</body>
</html>