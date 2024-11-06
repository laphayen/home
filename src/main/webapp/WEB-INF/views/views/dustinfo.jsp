<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dust Info</title>
</head>
<body>
        <c:forEach var="dust" items="${dustList}">
            <tr>
                <td>${dust.id}</td>
                <td>${dust.gugunName}</td>
                <td>${dust.grade}</td>
            </tr>
        </c:forEach>
</body>
</html>
