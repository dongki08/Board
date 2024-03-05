package com.green.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardSelVo {
    private Long iboard;
    private String title;
    private String ctnt;
    private String writer;
    private LocalDateTime createdAt;
}
