package com.green.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardCmt extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private Long icmt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "iboard", nullable = false)
    private Board board;

    @Column(length = 300, nullable = false)
    private String cmt;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String pw;

}
