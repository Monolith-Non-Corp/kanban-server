package com.kanban.springbootserver.dao.repository.impl;

import java.util.Optional;

import com.kanban.springbootserver.dao.BoardDao;
import com.kanban.springbootserver.dao.repository.BoardService;
import com.kanban.springbootserver.dao.repository.ProjectService;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Board;
import com.kanban.springbootserver.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;
    @Autowired
    private ProjectService projectService;

    @Override
    public Optional<Board> getBoardWithIdOnPathWithAccount(Account account, Long projectId, Long boardId) {
        return boardDao.findById(boardId);
    }

    @Override
    public Board saveBoardOnPathWithAccount(Account account, Long projectId, Board board) {
        Optional<Project> projectOptional = projectService.getProjectWithIdForAccount(account, projectId);
        return projectOptional.map(project -> {
            board.setProject(project);
            return boardDao.save(board);
        }).orElse(null);
    }

    @Override
    public void deleteBoardWithIdOnPathWithAccount(Account account, Long projectId, Long boardId) {
        Optional<Board> boardOptional = boardDao.findById(boardId);
        boardOptional.ifPresent(boardDao::delete);
    }
}
