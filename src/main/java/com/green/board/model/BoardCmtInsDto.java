package com.green.board.model;

import lombok.Data;

@Data
public class BoardCmtInsDto {
    private Long iboard;
    private String writer;
    private String cmt;
    private String pw;
}
