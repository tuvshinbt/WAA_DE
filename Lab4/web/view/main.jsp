<%-- 
    Document   : Names.jsp
    Created on : Nov 18, 2017, 12:04:55 PM
    Author     : tuvshuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab4 - MVC</title>
    </head>
    <body>
        <c:if test="${not empty main}">
            <div style="color: green;">List of Names</div>
            <c:forEach  items="${main.personMap}" var="person" >
                <c:out value="key=${person.key}  first name=${person.value.firstName} last name=${person.value.firstName}"></c:out>
                    <br/>
            </c:forEach>
        </c:if>
        <form action="names.html" method="GET">
            <input type="submit" value="Refresh all Names" />
        </form>
        <form action="addNames.html" method="GET">
            Key=<input type="text" name="key"/>
            First Name=<input type="text" name="firstName"/>
            Last Name=<input type="text" name="lastName"/>
            <input type="submit" value="Add" />
        </form>
        <form action="removeNames.html" method="GET">
            Key=<input type="text" name="key"/>
            <input type="submit" value="Remove" />
        </form>
    </body>
</html>
