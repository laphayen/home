<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${sessionScope.userinfo }" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="${root}/assets/css/app.css" rel="stylesheet" />
<title>SSAFY</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					<mark class="orange">회원 정보</mark>
				</h2>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<form id="form-join" method="POST" action="${root}/user/edit">
					<input type="hidden" name="action" value="edit" />
					<div class="mb-3">
						<label for="username" class="form-label">이름 : </label> 
						<input type="text" class="form-control" id="username" name="userName"
							placeholder="이름..." value="${user.userName}" />
					</div>
					<div class="mb-3">
						<label for="userid" class="form-label">아이디 : </label> 
						<input type="text" class="form-control" id="userid" name="userId"
							placeholder="아이디..." value="${user.userId}" readonly />
					</div>
					<div id="result-view" class="mb-3"></div>
					<div class="mb-3">
						<label for="userpwd" class="form-label">새 비밀번호 : </label> 
						<input type="password" class="form-control" id="userpwd" name="userPwd"
							placeholder="새 비밀번호를 입력하세요." />
					</div>
					<div class="mb-3">
						<label for="pwdcheck" class="form-label">비밀번호 확인 : </label> 
						<input type="password" class="form-control" id="pwdcheck"
							placeholder="비밀번호를 다시 입력하세요." />
					</div>

					<div class="mb-3">
						<label for="emailid" class="form-label">이메일 : </label>
						<div class="input-group">
							<input type="text" class="form-control" id="emailid" name="emailId"
								placeholder="이메일아이디" value="${user.emailId}" />
							<span class="input-group-text">@</span> 
							<select class="form-select" id="emaildomain" name="emailDomain" aria-label="이메일 도메인 선택">
								<option>선택</option>
								<option value="ssafy.com" <c:if test="${user.emailDomain eq 'ssafy.com'}">selected</c:if>>싸피</option>
								<option value="google.com" <c:if test="${user.emailDomain eq 'google.com'}">selected</c:if>>구글</option>
								<option value="naver.com" <c:if test="${user.emailDomain eq 'naver.com'}">selected</c:if>>네이버</option>
								<option value="kakao.com" <c:if test="${user.emailDomain eq 'kakao.com'}">selected</c:if>>카카오</option>
							</select>
						</div>
					</div>
					<div class="text-danger mb-2">${msg}</div>
					<div class="col-auto text-center">
						<button type="submit" id="btn-join" class="btn btn-outline-primary mb-3">수정</button>
						<button type="button" class="btn btn-outline-danger mb-3" onclick="deleteMember()">탈퇴</button>
						<button type="button" id="btn-mv-join" class="btn btn-outline-secondary mb-3" onclick="location.href='${root}/'">뒤로가기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script>
		document.querySelector("#btn-join").addEventListener("click", function() {
			if (!document.querySelector("#username").value) {
				alert("이름을 입력해주세요.");
				return;
			} else if (!document.querySelector("#emailid").value) {
				alert("이메일 아이디를 입력해주세요.");
				return;
			} else if (document.querySelector("#userpwd").value || document.querySelector("#pwdcheck").value) {
				if (document.querySelector("#userpwd").value !== document.querySelector("#pwdcheck").value) {
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
			}
			document.querySelector("#form-join").submit();
		});
	</script>
	
	<!-- 탈퇴 스크립트 -->
	<script>
    function deleteMember() {
        if (confirm("정말 탈퇴하시겠습니까?")) {
            const form = document.createElement("form");
            form.method = "POST";
            form.action = "${root}/user/delete";
            document.body.appendChild(form);
            form.submit();
        }
    }
</script>
</body>
</html>
