<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>관심 지역 목록</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>시/도</th>
				<th>군/구</th>
				<th>동</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="interest" items="${interestList}">
				<tr>
					<td>${interest.interestSidoName}</td>
					<td>${interest.interestGugunName}</td>
					<td>${interest.interestDongName}</td>
					<td>
						<!-- 삭제 버튼 폼 -->
						<form
							action="${pageContext.request.contextPath}/interest/deleteFavoriteArea"
							method="GET">
							<input type="hidden" name="interestId"
								value="${interest.interestId}">
							<button type="submit" class="btn btn-danger">삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
