<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Yahoo!!</title>
        </head>

        <body>
            <h1>Welcome Dear Student~ <%=request.getAttribute("username")%></h1>

            <h2>You can search students if you want to: </h2><br>
            <form action="/welcome.do" method="post">
                <input type="text" name="searchString" placeholder="Search Students by..." /><br>
                <input type="submit" value="Search" />
            </form>

        </body>

        </html>