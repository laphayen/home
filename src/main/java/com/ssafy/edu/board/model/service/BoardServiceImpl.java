package com.ssafy.edu.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.edu.board.BoardDto;
import com.ssafy.edu.board.model.repository.BoardMapper;
import com.ssafy.edu.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private static final int SIZE_PER_PAGE = 10; // 페이지당 게시글 수
    private static final int NAVI_SIZE = 10; // 네비게이션 사이즈
    private static final int DEFAULT_PGNO = 1; // 기본 페이지 번호

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public void writeArticle(BoardDto boardDto) throws Exception {
        boardMapper.writeArticle(boardDto);
    }

    @Override
    public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
        // 페이징 처리를 위한 계산
        int pgno;
        try {
            pgno = Integer.parseInt(map.getOrDefault("pgno", "1"));
            if (pgno < 1) pgno = DEFAULT_PGNO;
        } catch (NumberFormatException e) {
            pgno = DEFAULT_PGNO;
        }

        int sizePerPage = SIZE_PER_PAGE;
        int start = (pgno - 1) * sizePerPage;

        // 새로운 맵을 생성하여 정수형 값을 저장
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.putAll(map);
        paramMap.put("start", start);
        paramMap.put("sizePerPage", sizePerPage);

        return boardMapper.listArticle(paramMap);
    }

    @Override
    public BoardDto getArticle(int articleNo) throws Exception {
        boardMapper.updateHit(articleNo); // 조회수 증가
        return boardMapper.getArticle(articleNo);
    }

    @Override
    public void updateHit(int articleNo) throws Exception {
        boardMapper.updateHit(articleNo);
    }

    @Override
    public void modifyArticle(BoardDto boardDto) throws Exception {
        boardMapper.modifyArticle(boardDto);
    }

    @Override
    public void deleteArticle(int articleNo) throws Exception {
        boardMapper.deleteArticle(articleNo);
    }

    // 페이지 네비게이션
    @Override
    public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
        int currentPage;
        try {
            currentPage = Integer.parseInt(map.getOrDefault("pgno", "1"));
            if (currentPage < 1) {
                currentPage = DEFAULT_PGNO;
            }
        } catch (NumberFormatException e) {
            currentPage = DEFAULT_PGNO;
        }

        int sizePerPage = SIZE_PER_PAGE;
        int start = (currentPage - 1) * sizePerPage;

        // 새로운 맵을 생성하여 정수형 값을 저장
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.putAll(map);
        paramMap.put("start", start);
        paramMap.put("sizePerPage", sizePerPage);
        
        int totalCount = boardMapper.getTotalCount(paramMap);
        PageNavigation navigation = new PageNavigation();
        navigation.setCurrentPage(currentPage);
        navigation.setNaviSize(NAVI_SIZE);
        navigation.setTotalCount(totalCount);
        navigation.setTotalPageCount((totalCount - 1) / SIZE_PER_PAGE + 1);

        boolean startRange = currentPage <= NAVI_SIZE;
        navigation.setStartRange(startRange);
        boolean endRange = (navigation.getTotalPageCount() - 1) / NAVI_SIZE * NAVI_SIZE < currentPage;
        navigation.setEndRange(endRange);
        navigation.setCountPerPage(SIZE_PER_PAGE);
        navigation.setKey(map.get("key"));
        navigation.setWord(map.get("word"));
        navigation.makeNavigator();

        return navigation;
    }


}
