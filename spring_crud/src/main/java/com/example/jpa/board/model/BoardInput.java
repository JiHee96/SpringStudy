package com.example.jpa.board.model;

import com.example.jpa.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardInput {

    private String title;
    private String contents;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .contents(contents)
                .build();
    }

}