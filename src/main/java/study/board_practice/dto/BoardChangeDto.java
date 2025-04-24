package study.board_practice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import study.board_practice.entity.Board;

@Data
public class BoardChangeDto {

    private Long id;
    private String title;
    private String content;

    public BoardChangeDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
