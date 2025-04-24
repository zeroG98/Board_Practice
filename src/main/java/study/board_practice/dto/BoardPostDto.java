package study.board_practice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import study.board_practice.entity.Board;

@Data
public class BoardPostDto {

    private String title;
    private String content;

    public BoardPostDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
