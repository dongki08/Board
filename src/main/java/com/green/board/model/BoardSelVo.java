package com.green.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardSelVo {
    private Long iboard;
    private String title;
    private String ctnt;
    private String writer;
    private LocalDateTime createdAt;
}
