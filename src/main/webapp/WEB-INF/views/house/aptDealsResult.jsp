<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아파트 거래 결과</title>
</head>
<body>
	<div class="container mt-5">
		<h2>아파트 거래 결과</h2>

		<!-- 검색 결과 테이블 -->
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>아파트 이름</th>
					<th>층</th>
					<th>면적 (제곱미터)</th>
					<th>동 이름</th>
					<th>거래 금액</th>
				</tr>
			</thead>
			<tbody>
				<!-- houseList 반복하여 출력 -->
				<c:forEach var="house" items="${houseList}">
					<tr class="clickable-row">
						<td id="aptNm">${house.aptNm}</td>
						<td id="floor">${house.floor}</td>
						<td id="excluUseAr">${house.excluUseAr}</td>
						<td id="dongName">${house.dongName}</td>
						<td id="dealAmount">${house.dealAmount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 검색 결과가 없는 경우 메시지 표시 -->
		<c:if test="${empty houseList}">
			<p class="text-center">조회된 거래가 없습니다.</p>
		</c:if>
	</div>
</body>
</html>
