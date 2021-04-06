package com.example.jpa.board.model;

import com.example.jpa.board.entity.Board;

import java.time.LocalDateTime;

public class BoardListResponse {
    private Long id;
    private String title;
    private LocalDateTime updateDate;

    public BoardListResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.updateDate = board.getUpdateDate();
    }
}
