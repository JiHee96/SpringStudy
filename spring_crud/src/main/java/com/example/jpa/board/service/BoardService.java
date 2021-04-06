package com.example.jpa.board.service;

import com.example.jpa.board.entity.Board;
import com.example.jpa.board.model.BoardInput;
import com.example.jpa.board.model.BoardListResponse;
import com.example.jpa.board.model.BoardResponse;
import com.example.jpa.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    @Transactional
    public Long save(BoardInput boardInput) {
        return boardRepository.save(boardInput.toEntity()).getId();
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("id값이 정확하지 않습니다. id: " + id));

        return new BoardResponse(board);
    }

    @Transactional
    public Long update(Long id, BoardInput boardInput) {
        Board board =boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        board.update(boardInput.getTitle(),boardInput.getContents());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Board board =boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        boardRepository.delete(board);
    }

    public List<BoardListResponse> findAllDesc() {
        return boardRepository.findAllDesc()
                .stream()
                .map(BoardListResponse::new)
                .collect(Collectors.toList());
    }
}
