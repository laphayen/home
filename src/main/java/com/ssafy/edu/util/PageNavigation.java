package com.ssafy.edu.util;

public class PageNavigation {
	
	private boolean startRange; // 현재 페이지가 이전이 눌려지지 않는 범위의 페이지 체크
	private boolean endRange; // 현재 페이지가 다음이 눌려지지 않는 범위의 페이지 체크
	private int totalCount; // 총 게시글 갯수
	private int newCount; // 새글 갯수
	private int totalPageCount; // 총 페이지 갯수
	private int currentPage; // 현재 페이지 번호
	private int naviSize; // 네비게이션 사이즈
	private int countPerPage; // 페이지당 글 갯수
	private String navigator;
	
	// 검색 조건 필드 추가
	private String key; // 검색 키
	private String word; // 검색 단어

	// Getters and Setters...

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNewCount() {
		return newCount;
	}

	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public String getNavigator() {
		return navigator;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	
	// 검색 조건 getter/setter 추가
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void makeNavigator() {
		int startPage = (currentPage - 1) / naviSize * naviSize + 1;
		int endPage = startPage + naviSize - 1;
		if(totalPageCount < endPage)
			endPage = totalPageCount;
		
		StringBuilder builder = new StringBuilder();
		builder.append("		<ul class=\"pagination justify-content-center\"> \n");
		
		// '처음' 버튼
		builder.append("			<li class=\"page-item\" data-pg=\"1\"");
		if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
			builder.append(" data-key=\"").append(key).append("\" data-word=\"").append(word).append("\"");
		}
		builder.append("> \n");
		builder.append("				<a href=\"#\" class=\"page-link\">처음</a> \n");
		builder.append("			</li> \n");
		
		// '이전' 버튼
		int prevPgno = (startPage - 1) < 1 ? 1 : (startPage - 1);
		builder.append("			<li class=\"page-item\" data-pg=\"").append(prevPgno).append("\"");
		if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
			builder.append(" data-key=\"").append(key).append("\" data-word=\"").append(word).append("\"");
		}
		builder.append("> \n");
		builder.append("				<a href=\"#\" class=\"page-link\">이전</a> \n");
		builder.append("			</li> \n");
		
		// 페이지 번호 버튼들
		for(int i = startPage; i <= endPage; i++) {
			builder.append("			<li class=\"")
				   .append(currentPage == i ? "page-item active" : "page-item")
				   .append("\" data-pg=\"").append(i).append("\"");
			if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
				builder.append(" data-key=\"").append(key).append("\" data-word=\"").append(word).append("\"");
			}
			builder.append("> \n");
			builder.append("				<a href=\"#\" class=\"page-link\">").append(i).append("</a> \n");
			builder.append("			</li> \n");
		}
		
		// '다음' 버튼
		int nextPgno = (endPage + 1) > totalPageCount ? totalPageCount : (endPage + 1);
		builder.append("			<li class=\"page-item\" data-pg=\"").append(nextPgno).append("\"");
		if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
			builder.append(" data-key=\"").append(key).append("\" data-word=\"").append(word).append("\"");
		}
		builder.append("> \n");
		builder.append("				<a href=\"#\" class=\"page-link\">다음</a> \n");
		builder.append("			</li> \n");
		
		// '마지막' 버튼
		builder.append("			<li class=\"page-item\" data-pg=\"").append(totalPageCount).append("\"");
		if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
			builder.append(" data-key=\"").append(key).append("\" data-word=\"").append(word).append("\"");
		}
		builder.append("> \n");
		builder.append("				<a href=\"#\" class=\"page-link\">마지막</a> \n");
		builder.append("			</li> \n");
		
		builder.append("		</ul> \n");
		
		this.navigator = builder.toString();
	}

}
