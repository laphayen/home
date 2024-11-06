<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Business Info</title>
</head>
<body>
        <c:forEach var="business" items="${businessList}">
            <tr>
                <td>${business.name}</td>
                <td>${business.industrySpecificName}</td>
                <td>${business.address}</td>
            </tr>
        </c:forEach>
</body>
</html>
