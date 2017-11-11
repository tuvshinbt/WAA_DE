<%-- 
    Document   : Lab1
    Created on : Nov 11, 2017, 10:40:56 AM
    Author     : tuvshuu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab3 - Lab1</title>
    </head>
    <body>
        <h1>Login</h1>
        <h3>
            <c:if test="${not empty errorMsg}">
                <span style="color: red;"><c:out value="${errorMsg}"/></span>
            </c:if>
        </h3>
        <form method=GET action=LogonServlet>
            Username=<input type=text name=username> <br>
            Password=<input type=text name=password>
            <input type=submit value='Logon'>
        </form>
    </body>
</html>
