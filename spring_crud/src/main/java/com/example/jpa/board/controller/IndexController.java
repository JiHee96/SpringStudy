package com.example.jpa.board.controller;

import com.example.jpa.board.model.BoardResponse;
import com.example.jpa.board.repository.BoardRepository;
import com.example.jpa.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import java.util.Optional;

@Controller
public class IndexController {

    private BoardService boardService;

    public IndexController(BoardService boardService) {
        this.boardService = boardService;
    }

//    public IndexController(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

//    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("board", boardService.findAllDesc());
        return "index";
    }

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("board", boardRepository.findAll());
//        return "index";
//    }

    @GetMapping("/board/save")
    public String boardSave() {
        return "board-save";
    }

//    @GetMapping("/board/save")
//    public String boardSave() {
//        return "board-save";
//    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model) {

        BoardResponse board = boardService.findById(id);
        model.addAttribute("board", board);

        return "board-update";
    }

//    @GetMapping("/board/update/{id}")
//    public String boardUpdate(@PathVariable Long id, Model model){
//        Optional<Board> optionalBoard = boardRepository.findById(id);
//        Board board = optionalBoard.get();
//        model.addAttribute("board", board);
//
//        return "board-update";
//    }
}
