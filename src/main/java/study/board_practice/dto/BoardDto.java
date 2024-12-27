package study.board_practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import study.board_practice.entity.Board;

@Getter
@RequiredArgsConstructor
public class BoardDto {

    private Long boardId;
    private String title;
    private String content;

    public BoardDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
