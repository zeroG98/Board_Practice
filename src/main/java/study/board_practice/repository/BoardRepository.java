package study.board_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.board_practice.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
