package com.ssafy.edu.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.edu.board.BoardDto;
import com.ssafy.edu.board.model.service.BoardService;
import com.ssafy.edu.member.MemberDto;
import com.ssafy.edu.util.PageNavigation;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private static final int DEFAULT_PGNO = 1;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 글 목록 보기
    @GetMapping
    public String listArticle(@RequestParam Map<String, String> paramMap, Model model) throws Exception {
        // 기본 페이지 번호 설정
        int pgno;
        try {
            pgno = Integer.parseInt(paramMap.getOrDefault("pgno", "1"));
            if (pgno < 1) {
                pgno = DEFAULT_PGNO;
            }
        } catch (NumberFormatException e) {
            pgno = DEFAULT_PGNO;
        }
        paramMap.put("pgno", String.valueOf(pgno));

        // 검색어 트림 및 유효성 검사
        String key = paramMap.get("key");
        String word = paramMap.get("word");
        if (word != null && !word.trim().isEmpty()) {
            paramMap.put("word", word.trim());
        } else {
            paramMap.put("word", "");
        }

        List<BoardDto> articles = boardService.listArticle(paramMap);
        model.addAttribute("articles", articles);

        PageNavigation navigation = boardService.makePageNavigation(paramMap);
        navigation.setKey(key);
        navigation.setWord(word);
        model.addAttribute("navigation", navigation);

        // 검색 조건과 검색어를 뷰에 전달하여 폼에 유지
        model.addAttribute("key", key);
        model.addAttribute("word", word);

        return "board/list";
    }

    // 글 상세 보기
    @GetMapping("/view")
    public String getArticle(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
        BoardDto article = boardService.getArticle(articleNo);
        model.addAttribute("article", article);
        return "board/view";
    }

    // 글 작성 페이지로 이동
    @GetMapping("/mvwrite")
    public String moveWriteArticle() {
        return "board/write";
    }

    // 글 작성
    @PostMapping("/write")
    public String writeArticle(@ModelAttribute BoardDto boardDto, HttpSession session) throws Exception {
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if (memberDto != null) {
            boardDto.setUserId(memberDto.getUserId());
            boardService.writeArticle(boardDto);
            return "redirect:/board";
        } else {
            return "redirect:/user/login";
        }
    }

    // 글 수정 페이지로 이동
    @GetMapping("/mvmodify")
    public String moveModifyArticle(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
        BoardDto article = boardService.getArticle(articleNo);
        model.addAttribute("article", article);
        return "board/modify";
    }

    // 글 수정
    @PostMapping("/modify")
    public String modifyArticle(@ModelAttribute BoardDto boardDto) throws Exception {
        boardService.modifyArticle(boardDto);
        return "redirect:/board/view?articleNo=" + boardDto.getArticleNo();
    }

    // 글 삭제
    @GetMapping("/delete")
    public String deleteArticle(@RequestParam("articleNo") int articleNo) throws Exception {
        boardService.deleteArticle(articleNo);
        return "redirect:/board";
    }

}