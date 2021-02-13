package com.kanban.springbootserver.dao.repository.impl;

import java.time.ZonedDateTime;
import java.util.Optional;

import com.kanban.springbootserver.dao.TaskDao;
import com.kanban.springbootserver.dao.repository.BoardService;
import com.kanban.springbootserver.dao.repository.TaskService;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Board;
import com.kanban.springbootserver.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private BoardService boardService;

    @Override
    public Optional<Task> getTaskWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId) {
        return taskDao.findById(taskId);
    }

    @Override
    public Task saveTaskOnPathWithAccount(Account account, Long projectId, Long boardId, Task task) {
        Optional<Board> boardOptional = boardService.getBoardWithIdOnPathWithAccount(account, projectId, boardId);
        return boardOptional.map(board -> {
            task.setAccount(account);
            task.setBoard(board);
            task.setDateCreated(ZonedDateTime.now());
            task.setLastUpdated(ZonedDateTime.now());
            return taskDao.save(task);
        }).orElse(null);
    }

    @Override
    public Task updateTaskWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId) {
        Optional<Board> boardOptional = boardService.getBoardWithIdOnPathWithAccount(account, projectId, boardId);
        return boardOptional.flatMap(board -> {
            Optional<Task> taskOptional = taskDao.findById(taskId);
            return taskOptional.map(task -> {
                task.setBoard(board);
                task.setLastUpdated(ZonedDateTime.now());
                return taskDao.save(task);
            });
        }).orElse(null);
    }

    @Override
    public void deteleTaskWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId) {
        Optional<Task> taskOptional = taskDao.findById(taskId);
        taskOptional.ifPresent(taskDao::delete);
    }
}
