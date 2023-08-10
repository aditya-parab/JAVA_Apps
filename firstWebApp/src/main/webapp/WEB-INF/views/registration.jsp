<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>

    <head>
        <title>Yahoo!!</title>
    </head>

    <body>
        <h1 style="font-size: large;">Student Registration Form</h1>

        <form action="/register.do" method="POST">

            Name: <input name="name" type="text" /><br>
            Username: <input name="username" type="text" /><br>
            Password: <input name="password" type="password" /><br>
            Email: <input name="email" type="email" /><br>
            Course: <input name="course" type="text" /><br>
            Age: <input name="age" type="number" /><br>
            <button type="submit">Register</button><br>
            <button type="login">login</button>
        </form>

        <h1 id="registeredMessage" style="display: none;">Student is registered!</h1>
        <h1 id="NotRegisteredMessage" style="display: none;">Student is not registered!</h1>

        <script>
            var flag = <%= request.getAttribute("flag") %>;
            var registeredMessage = document.getElementById('registeredMessage');

            if (flag) {
                registeredMessage.style.display = 'block';
                NotRegisteredMessage.style.display = 'none';
            } else {
                registeredMessage.style.display = 'none';
                NotRegisteredMessage.style.display = 'block';
            }
        </script>

    </body>

    </html>