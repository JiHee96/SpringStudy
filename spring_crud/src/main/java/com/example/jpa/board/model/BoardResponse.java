package com.example.jpa.board.model;

import com.example.jpa.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponse {

    private Long id;
    private String title;
    private String contents;

    public BoardResponse(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
    }
}
