<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.neebalgurukul.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
</head>
<body>
    <h1>List of Students</h1>
    
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Age</th>
        </tr>
        <% List<Student> studList = (List<Student>) request.getAttribute("studentList"); %>
        <% for (Student student : studList) { %>
            <tr>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getCourse() %></td>
                <td><%= student.getAge() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
