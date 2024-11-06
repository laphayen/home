<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
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
                    <mark class="orange">회원가입</mark>
                </h2>
            </div>
            <div class="col-lg-8 col-md-10 col-sm-12">
                <form id="form-join" method="POST" action="${root}/user/join">

                    <div class="mb-3">
                        <label for="user_name" class="form-label">이름 : </label> 
                        <input type="text" class="form-control" id="user_name" name="userName" placeholder="이름..." />
                    </div>
                    <div class="mb-3">
                        <label for="user_id" class="form-label">아이디 : </label> 
                        <input type="text" class="form-control" id="user_id" name="userId" placeholder="아이디..." />
                    </div>
                    <div id="result-view" class="mb-3"></div>
                    <div class="mb-3">
                        <label for="user_password" class="form-label">비밀번호 : </label> 
                        <input type="password" class="form-control" id="user_pass" name="userPwd" placeholder="비밀번호..." />
                    </div>
                    <div class="mb-3">
                        <label for="pwdcheck" class="form-label">비밀번호확인 : </label> 
                        <input type="password" class="form-control" id="pwdcheck" placeholder="비밀번호확인..." />
                    </div>
                    <div class="mb-3">
                        <label for="emailid" class="form-label">이메일 : </label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="emailid" name="emailId" placeholder="이메일아이디" /> 
                            <span class="input-group-text">@</span> 
                            <select class="form-select" id="emaildomain" name="emailDomain" aria-label="이메일 도메인 선택">
                                <option selected>선택</option>
                                <option value="ssafy.com">싸피</option>
                                <option value="google.com">구글</option>
                                <option value="naver.com">네이버</option>
                                <option value="kakao.com">카카오</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-auto text-center">
                        <button type="submit" id="btn-join" class="btn btn-outline-primary mb-3">회원가입</button>
                        <button type="reset" class="btn btn-outline-success mb-3">초기화</button>
                        <button type="button" id="btn-mv-join" class="btn btn-outline-secondary mb-3" onclick="location.href='${root}/'">뒤로가기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
