<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 공통 헤더 포함 --%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<%-- 확인용 모달 창 포함 (필요한 경우) --%>
<%@ include file="/WEB-INF/views/common/confirm.jsp"%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
            <h2 class="my-3 py-3 shadow-sm bg-light text-center">
                <mark class="sky">게시판</mark>
            </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
            <div class="row align-self-center mb-2">
                <div class="col-md-2 text-start">
                    <button type="button" id="btn-mv-register"
                        class="btn btn-outline-primary btn-sm">글쓰기</button>
                </div>
                <div class="col-md-7 offset-3">
                    <form class="d-flex" id="form-search" method="get"
                        action="${pageContext.request.contextPath}/board">
                        <input type="hidden" name="pgno" value="1" />
                        <select name="key"
                            id="key" class="form-select form-select-sm ms-5 me-1 w-50"
                            aria-label="검색조건">
                            <option value="" <c:if test="${empty param.key}">selected</c:if>>검색조건</option>
                            <option value="article_no" <c:if test="${param.key eq 'article_no'}">selected</c:if>>글번호</option>
                            <option value="subject" <c:if test="${param.key eq 'subject'}">selected</c:if>>제목</option>
                            <option value="user_id" <c:if test="${param.key eq 'user_id'}">selected</c:if>>작성자</option>
                        </select>
                        <div class="input-group input-group-sm">
                            <input type="text" name="word" id="word" class="form-control"
                                placeholder="검색어..." value="${param.word}" />
                            <button id="btn-search" class="btn btn-dark" type="submit">검색</button>
                        </div>
                    </form>
                </div>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr class="text-center">
                        <th scope="col">글번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="article" items="${articles}">
                        <tr class="text-center">
                            <th scope="row">${article.articleNo}</th>
                            <td class="text-start">
                                <a href="#" class="article-title link-dark" data-no="${article.articleNo}" style="text-decoration: none">
                                    ${article.subject}
                                </a>
                            </td>
                            <td>${article.userId}</td>
                            <td>${article.hit}</td>
                            <td>${article.registerTime}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty articles}">
                        <tr>
                            <td colspan="5" class="text-center">검색 결과가 없습니다.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
            <div class="row">
                <!-- 페이지 네비게이션 표시 -->
                <c:if test="${not empty navigation}">
                    <c:out value="${navigation.navigator}" escapeXml="false" />
                </c:if>
            </div>

            <button type="button" class="btn btn-outline-primary btn-sm"
                onclick="location.href='${pageContext.request.contextPath}/'">홈페이지</button>
        </div>
    </div>
</div>

<!-- 파라미터 전달용 폼 -->
<form id="form-param" method="get"
    action="${pageContext.request.contextPath}/board">
    <input type="hidden" id="p-pgno" name="pgno" value="">
    <input type="hidden" id="p-key" name="key" value="${param.key}">
    <input type="hidden" id="p-word" name="word" value="${param.word}">
</form>
<script>
    // 상세 페이지로 이동
    let titles = document.querySelectorAll(".article-title");
    titles.forEach(function(title) {
        title.addEventListener("click", function() {
            location.href = "${pageContext.request.contextPath}/board/view?articleNo=" + this.getAttribute("data-no");
        });
    });

    // 글쓰기 페이지로 이동
    document.querySelector("#btn-mv-register").addEventListener("click", function() {
        location.href = "${pageContext.request.contextPath}/board/mvwrite";
    });

    // 페이지 네비게이션 처리
    let pages = document.querySelectorAll(".page-link");
    pages.forEach(function(page) {
        page.addEventListener("click", function(event) {
            event.preventDefault();
            document.querySelector("#p-pgno").value = this.parentElement.getAttribute("data-pg");
            document.querySelector("#p-key").value = this.parentElement.getAttribute("data-key") || '';
            document.querySelector("#p-word").value = this.parentElement.getAttribute("data-word") || '';
            document.querySelector("#form-param").submit();
        });
    });
</script>

<%-- 공통 푸터 포함 --%>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
