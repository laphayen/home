package com.ssafy.edu.board.model.repository;

import java.util.List;
import java.util.Map;

import com.ssafy.edu.board.BoardDto;

public interface BoardMapper {

    void writeArticle(BoardDto boardDto) throws Exception;

    List<BoardDto> listArticle(Map<String, Object> map) throws Exception;

    int getTotalCount(Map<String, Object> map) throws Exception;

    BoardDto getArticle(int articleNo) throws Exception;

    void updateHit(int articleNo) throws Exception;

    void modifyArticle(BoardDto boardDto) throws Exception;

    void deleteArticle(int articleNo) throws Exception;
    
}
