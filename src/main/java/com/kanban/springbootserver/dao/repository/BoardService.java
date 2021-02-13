package com.kanban.springbootserver.dao.repository;

import java.util.Optional;

import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Board;

public interface BoardService {
    Optional<Board> getBoardWithIdOnPathWithAccount(Account account, Long projectId, Long boardId);
    Board saveBoardOnPathWithAccount(Account account, Long projectId, Board board);
    void deleteBoardWithIdOnPathWithAccount(Account account, Long projectId, Long boardId);
}
