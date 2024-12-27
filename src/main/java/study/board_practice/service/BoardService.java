package study.board_practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.board_practice.entity.Board;
import study.board_practice.repository.BoardRepository;

import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //게시판 저장(작성)
    @Transactional
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    //게시판 조회
    public List<Board> findBoard() {
        return boardRepository.findAll();
    }

    //게시판 상세 조회
    public Board findById(Long boardId) {

        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("데이터가 없습니다."));
    }


    @Transactional
    public void deleteBoard(Long boardId) {

        boardRepository.deleteById(boardId);
    }
}
