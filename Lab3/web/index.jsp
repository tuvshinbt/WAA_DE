<%-- 
    Document   : index
    Created on : Nov 11, 2017, 10:29:53 AM
    Author     : tuvshuu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab3 - 1</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach begin="1" end="10" step="1" var="i" >
            <c:out value="${i}"></c:out>
                <br/>
        </c:forEach>
    </body>
</html>
