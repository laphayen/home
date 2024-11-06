<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }" />
<c:set var="user" value="${sessionScope.userinfo }" />
<c:set var="aptDealList" value="${root }/house/aptDealsResult" />

<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="idck" value=" checked" />
	<c:set var="saveid" value="${cookie.ssafy_id.value}" />
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>집싸피</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${root}/assets/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="map"></div>
	<div id="sidebar">
		<!-- 탭 네비게이션 -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="select-tab"
				data-toggle="tab" href="#select" role="tab" aria-controls="select"
				aria-selected="false">지역 선택</a></li>
			<li class="nav-item"><a class="nav-link" id="search-tab"
				data-toggle="tab" href="#search" role="tab" aria-controls="search"
				aria-selected="true">관심 지역</a></li>
			<li class="nav-item"><a class="nav-link" id="dustinfo-tab"
				data-toggle="tab" href="#dustinfo" role="tab"
				aria-controls="dustinfo" aria-selected="true">대기 정보</a></li>
			<!-- <li class="nav-item"><a class="nav-link" id="businessinfo-tab"
				data-toggle="tab" href="#businessinfo" role="tab"
				aria-controls="businessinfo" aria-selected="true">업장 정보</a></li> -->
		</ul>
		<div class="tab-content" id="myTabContent">
			<!-- 첫 번째 탭: 시도, 구군, 동 선택 -->
			<div class="tab-pane fade show active" id="select" role="tabpanel"
				aria-labelledby="select-tab">
				<h4>지역 선택</h4>
				<form id="selection-form" action="${root}/addFavoriteArea"
					method="post">
					<div class="form-group">
						<label for="sido-select">시도 선택</label> <select
							class="form-control" id="sido-select" name="province"></select>
					</div>
					<div class="form-group">
						<label for="gugun-select">구군 선택</label> <select
							class="form-control" id="gugun-select" name="city">
							<option value="">구군선택</option>
						</select>
					</div>
					<div class="form-group">
						<label for="dong-select">동 선택</label> <select class="form-control"
							id="dong-select" name="dong">
							<option value="">동선택</option>
						</select>
					</div>
					<div class="form-group">
						<label for="year-select">연도 선택</label> <select
							class="form-control" id="year-select" name="year">
							<option value="">연도선택</option>
						</select>
					</div>
					<div class="form-group">
						<label for="month-select">월 선택</label> <select
							class="form-control" id="month-select" name="month">
							<option value="">월선택</option>
						</select>
					</div>
					<input type="hidden" id="latitude" name="latitude" /> <input
						type="hidden" id="longitude" name="longitude" />
					<div class="mb-4 text-right">
						<button type="button" class="btn btn-primary"
							id="selection-search-btn"
							formaction="${root}/house/searchAptDeals" formmethod="POST">검색</button>
						<button type="submit" class="btn btn-primary" id="areaAddBtn"
							formaction="${root}/interest/addFavoriteArea">관심 지역으로 추가</button>
					</div>
				</form>

				<div id="selection-results">
					<table class="table table-hover text-center" style="display: none">
						<tr>
							<th>아파트이름</th>
							<th>층</th>
							<th>면적</th>
							<th>법정동</th>
							<th>거래금액</th>
						</tr>
						<tbody id="aptlist">

						</tbody>
					</table>
				</div>
			</div>

			<!-- 두 번째 탭: 관심 지역 -->
			<div class="tab-pane fade" id="search" role="tabpanel"
				aria-labelledby="search-tab">
				<h4>관심 지역</h4>
				<div class="container my-5">
					<table class="table table-bordered">
						<thead>
						</thead>
						<tbody id="fav-list">
						</tbody>
					</table>
					<button class="btn btn-primary" onclick="fetchInterestInfo()">관심
						지역 정보 조회</button>
				</div>
			</div>

			<!-- 세 번째 탭: 아파트 정보 -->
			<div class="tab-pane fade" id="aptinfo" role="tabpanel"
				aria-labelledby="search-tab">
				<h4>아파트 정보</h4>
				<div class="container my-5">
					<table class="table table-hover text-center">
						<tr>
							<th>아파트이름</th>
							<th>층</th>
							<th>면적</th>
							<th>법정동</th>
							<th>거래금액</th>
						</tr>
						<tbody id="aptinfolist"></tbody>
					</table>
				</div>
			</div>

			<!-- 네 번째 탭: 대기 정보 -->
			<div class="tab-pane fade" id="dustinfo" role="tabpanel"
				aria-labelledby="search-tab">
				<h4>대기 정보</h4>
				<div class="container my-5">
					<table class="table table-hover text-center">
						<tr>
							<th>번호</th>
							<th>군/구</th>
							<th>등급</th>
						</tr>
						<tbody id="dustinfolist"></tbody>
					</table>
					<button class="btn btn-primary" onclick="fetchDustInfo()">대기
						정보 조회</button>
				</div>
			</div>


		</div>
	</div>

	<!-- 상단 로그인바 ////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<div id="top-right-buttons">
		<button class="btn btn-custom info-btn" id="info-btn"
			onclick="location.href='${root}/board'">게시판</button>
		<c:choose>
			<c:when test="${user == null }">
				<button class="btn btn-custom" id="login-btn" data-toggle="modal"
					data-target="#loginModal">로그인</button>
				<button class="btn btn-custom" id="signup-btn"
					onclick="location.href='${root}/user/joinPage'">회원가입</button>
			</c:when>
			<c:otherwise>
				<button class="btn" id="profile-btn"
					onclick="location.href='${root}/user/infoPage'">회원정보</button>
				<button class="btn" id="logout-btn"
					onclick="location.href='${root}/user/logout'">로그아웃</button>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- 하단 추가 기능바 ////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<div id="bottom-right-buttons">
		<button class="btn btn-custom hospital-btn" onclick="showHospital()">병원</button>
		<button class="btn btn-custom subway-btn" onclick="showSubways()">지하철</button>
	</div>

	<!-- 로그인 모달 ////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="loginModalLabel">로그인</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="form-login" method="POST" action="${root}/user/login">
                        <div class="form-check mb-3 float-end">
                            <input class="form-check-input" type="checkbox" value="ok" id="saveid" name="saveid" ${idck} />
                            <label class="form-check-label" for="saveid">아이디 저장</label>
                        </div>
                        <div class="mb-3">
                            <label for="userid" class="form-label">아이디:</label>
                            <input type="text" class="form-control" id="userid" name="userid" placeholder="아이디..." value="${saveid}" />
                        </div>
                        <div class="mb-3">
                            <label for="userpwd" class="form-label">비밀번호:</label>
                            <input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="비밀번호..." />
                        </div>
                        <c:if test="${error != null}">
                            <div class="text-danger mb-2">${error}</div>
                        </c:if>
                        <div class="text-center">
                            <button type="button" id="btn-login" class="btn btn-primary mb-3">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

	<!-- 외부 라이브러리 -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


	<!-- 카카오맵 API -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=05a47079bf95d0a15cefbb1c9fc58b82&libraries=services"></script>


	<!-- 로컬 파일 불러오기 -->
	<script type="text/javascript" src="${root}/assets/js/map.js"></script>
	<script type="text/javascript" src="${root}/assets/js/key.js"></script>
	<script type="text/javascript" src="${root}/assets/js/user.js"></script>



	<script>
	<!-- 로그인 모달 js ///////////////////////////////////////////////////////////////////////////////////////////////////// -->
	document.querySelector("#btn-login").addEventListener("click", function() {
	    // 아이디 입력 확인
	    if (!document.querySelector("#userid").value) {
	        alert("아이디를 입력하세요!");
	        document.querySelector("#userid").focus();
	        return;
	    }
	    // 비밀번호 입력 확인
	    if (!document.querySelector("#userpwd").value) {
	        alert("비밀번호를 입력하세요!");
	        document.querySelector("#userpwd").focus();
	        return;
	    }
	    // 입력 확인이 완료되면 폼 제출
	    document.querySelector("#form-login").submit();
	});
	<% if (Boolean.TRUE.equals(request.getAttribute("loginFail"))) { %>
    $(document).ready(function() {
        alert("아이디 또는 비밀번호가 잘못되었습니다."); // Display alert for login failure
        $('#loginModal').modal('show'); // Keep the modal open
    });
	<% } %>
	</script>







	<script>	
	/* 미세정보 스크립트 -------------------------------------------------------------------------------------------------- */
	
function fetchDustInfo() {
    fetch('<c:url value="/dustinfo/dustList" />')//여기 수정함
    .then(response => response.text())
    .then(html => {
        document.getElementById("dustinfolist").innerHTML = html;
    })
    .catch(err => console.error('Error fetching dust info:', err));
}

function fetchBusiness(callback) {
	let pos = map.getCenter();
	let geocoder = new kakao.maps.services.Geocoder();
	let dong;
	
	geocoder.coord2RegionCode(pos.getLng(), pos.getLat(), (result, status) => {
		if (status == kakao.maps.services.Status.OK) {
			dong = result[0].region_3depth_name;
			console.log(dong);
		}
		
		fetch('<c:url value="/business/localBusiness" />', {
			method: "GET",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify({
				action: "getList",
				dong: dong
			})
		})
	    	.then(response => response.text())
	    	.then(html => {
	        	document.getElementById("businessinfolist").innerHTML = html;
	    	})
	    	.catch(err => console.error('Error fetching business info:', err));
	});
}

window.onload = function () {
	kakao.maps.event.addListener(map, 'center_changed', fetchBusiness);
}

function fetchInterestInfo() {
    fetch('<c:url value="/interest/listFavoriteAreas" />')
    .then(response => response.text())
    .then(html => {
        document.getElementById("fav-list").innerHTML = html;
    })
    .catch(err => console.error('Error fetching interest info:', err));
}

function addFavoriteArea() {
    const form = document.getElementById('selection-form');
    const formData = new FormData(form);

    fetch('<c:url value="/addFavoriteArea" />', {
        method: 'POST',
        body: formData
    })
    .then(response => response.text())
    .then(result => {
        alert('관심 지역이 추가되었습니다.');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('관심 지역 추가에 실패했습니다.');
    });
}
</script>
</body>
</html>
