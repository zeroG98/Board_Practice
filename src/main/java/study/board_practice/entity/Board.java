package study.board_practice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@NoArgsConstructor
@Getter @Setter
/*@Data//실사용은 위험함(DTO에선 상황에 따라 사용해도 괜찮음)*/
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
