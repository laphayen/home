<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<c:if test="${cookie.ssafy_id.value ne null}">
    <c:set var="idck" value="checked" />
    <c:set var="saveid" value="${cookie.ssafy_id.value}" />
</c:if>

<div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="orange">로그인</mark>
        </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
        <form id="form-login" method="POST" action="${root}/user/login">
            <div class="form-check mb-3 float-end">
                <input class="form-check-input" type="checkbox" value="ok" id="saveid" name="saveid" ${idck} />
                <label class="form-check-label" for="saveid"> 아이디저장 </label>
            </div>
            <div class="mb-3">
                <label for="userid" class="form-label">아이디 :</label>
                <input type="text" class="form-control" id="userid" name="userid" placeholder="아이디..." value="${saveid}" />
            </div>
            <div class="mb-3">
                <label for="userpwd" class="form-label">비밀번호 :</label>
                <input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="비밀번호..." />
            </div>
            <div class="text-danger mb-2">${error}</div>
            <div class="col-auto text-center">
                <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">로그인</button>
                <button type="button" id="btn-mv-join" class="btn btn-outline-secondary mb-3" onclick="location.href='${root}/'">뒤로가기</button>
            </div>
        </form>
    </div>
</div>

<script>
    document.querySelector("#btn-login").addEventListener("click", function() {
        if (!document.querySelector("#userid").value) {
            alert("아이디 입력!!");
            return;
        } else if (!document.querySelector("#userpwd").value) {
            alert("비밀번호 입력!!");
            return;
        } else {
            document.querySelector("#form-login").submit();
        }
    });
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
