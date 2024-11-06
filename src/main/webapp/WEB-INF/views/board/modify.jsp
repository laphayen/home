<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/confirm.jsp"%>
<div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">글수정</mark>
        </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
        <form id="form-modify" method="POST" action="${root}/board/modify">
            <input type="hidden" name="articleNo" value="${article.articleNo}">
            <div class="mb-3">
                <label for="subject" class="form-label">제목 : </label>
                <input type="text" class="form-control" id="subject" name="subject" value="${article.subject}" />
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용 : </label>
                <textarea class="form-control" id="content" name="content" rows="7">${article.content}</textarea>
            </div>
            <div class="col-auto text-center">
                <!-- Changed type to 'submit' -->
                <button type="submit" id="btn-modify" class="btn btn-outline-primary">수정하기</button>
                <button type="button" id="btn-delete" class="btn btn-outline-danger">삭제</button>
            </div>
        </form>
    </div>
</div>
<script>
    var articleNo = "${article.articleNo}";
    console.log(articleNo);
    console.log("이거는 찍혀?");
    // Removed the click handler for '#btn-modify'

    // Keep the delete functionality
    document.querySelector("#btn-delete").addEventListener("click", function() {
        if (confirm("정말 삭제하시겠습니까?")) {
            location.href = "${root}/board/delete?articleNo=" + articleNo; // Ensure parameter name matches the controller
        }
    });
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
