package com.ssafy.edu.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.edu.board.BoardDto;
import com.ssafy.edu.util.PageNavigation;

public interface BoardService {

	void writeArticle(BoardDto boardDto) throws Exception;
	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	
	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
}
