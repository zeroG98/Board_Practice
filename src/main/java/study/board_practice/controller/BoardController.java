package study.board_practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.board_practice.dto.BoardDto;
import study.board_practice.entity.Board;
import study.board_practice.service.BoardService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시글 작성
    @GetMapping("/write")
    public String createForm(Model model) {
        model.addAttribute("form", new Board());

        return "boardWrite";
    }

    //게시글 작성
    @PostMapping("/write")
    public String create(Board board) {
        Board write = new Board();
        write.setTitle(board.getTitle());
        write.setContent(board.getContent());

        boardService.saveBoard(write);
        return "redirect:/board";
    }

    //게시글 목록
    @GetMapping
    public String list(Model model) {
        List<Board> boards = boardService.findBoard();
        model.addAttribute("list", boards);

        return "boardList";
    }

    //게시글 상세
    @GetMapping("/view/{id}")
    public String boardView(@PathVariable("id") Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);

        return "boardView";
    }

    //게시글 수정
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "editForm";
    }

    //게시글 수정
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long boardId, Board board) {
        Board change = boardService.findById(boardId);

        change.setId(board.getId());
        change.setTitle(board.getTitle());
        change.setContent(board.getContent());

        boardService.saveBoard(change);
        return "redirect:/board";
    }

    @GetMapping("/delete")
    public String boardDelete(@RequestParam("id") Long id) {

        boardService.deleteBoard(id);

        return "redirect:/board";
    }


}
