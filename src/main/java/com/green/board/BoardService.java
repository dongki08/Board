package com.green.board;

import com.green.board.entity.Board;
import com.green.board.entity.BoardCmt;
import com.green.board.model.BoardCmtInsDto;
import com.green.board.model.BoardSelVo;
import com.green.board.model.BoardUpdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardrepository;
    private final BoardCmtRepository boardCmtRepository;

    public long postBoard(Board board) {
        String hashedPw = BCrypt.hashpw(board.getPw(), BCrypt.gensalt());
        board.setPw(hashedPw);
        boardrepository.save(board);
        return board.getIboard();
    }

    @Transactional
    public long postBoardCmt(BoardCmtInsDto dto) {
        Board board = new Board();
        board.setIboard(dto.getIboard());
        BoardCmt boardCmt = new BoardCmt();
        String hashedPw = BCrypt.hashpw(dto.getPw(), BCrypt.gensalt());
        boardCmt.setPw(hashedPw);
        boardCmt.setBoard(board);
        boardCmt.setWriter(dto.getWriter());
        boardCmt.setCmt(dto.getCmt());

        boardCmtRepository.save(boardCmt);
        return boardCmt.getIcmt();
    }

    public List<BoardSelVo> getBoardList(Pageable pageable) {
        Page<Board> list = boardrepository.findAll(pageable);
        return null;
    }

    @Transactional
    public long putBoard(BoardUpdDto dto) {
        Board board = boardrepository.getReferenceById(dto.getIboard());
        if(!BCrypt.checkpw(dto.getPw(), board.getPw())) {
            return 0L;
        }
        board.setTitle(dto.getTitle());
        board.setCtnt(dto.getCtnt());
        return 1L;
    }

    public void delBoard(Long iboard) {
        Board board = boardrepository.getReferenceById(iboard);
        boardCmtRepository.deleteByBoard(iboard);
        boardrepository.delete(board);
    }
}
