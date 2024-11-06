<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/confirm.jsp"%>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">글쓰기</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<form id="form-register" method="POST" action="${root}/board/write">
			<input type="hidden" name="action" value="write">
			<div class="mb-3">
				<label for="subject" class="form-label">제목 : </label> <input
					type="text" class="form-control" id="subject" name="subject"
					placeholder="제목..." />
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">내용 : </label>
				<textarea class="form-control" id="content" name="content" rows="7"></textarea>
			</div>
			<div class="col-auto text-center">
				<button type="button" id="btn-register"
					class="btn btn-outline-primary mb-3">글작성</button>
				<button type="reset" class="btn btn-outline-danger mb-3">초기화</button>
				<button type="button" id="btn-mv-join" class="btn btn-outline-secondary mb-3" onclick="location.href='${root}/board'">뒤로가기</button>
			</div>
		</form>
	</div>
</div>
<script>
    document.querySelector("#btn-register").addEventListener("click", function () {
    	  if (!document.querySelector("#subject").value) {
    	    alert("제목 입력!!");
    	    return;
    	  } else if (!document.querySelector("#content").value) {
    	    alert("내용 입력!!");
    	    return;
    	  } else {
    	    document.querySelector("#form-register").submit();
    	  }
    	});

    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
