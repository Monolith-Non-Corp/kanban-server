package com.kanban.springbootserver.dao.repository;

import java.util.Optional;

import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Task;

public interface TaskService {
    Optional<Task> getTaskWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId);
    Task saveTaskOnPathWithAccount(Account account, Long projectId, Long boardId, Task task);
    Task updateTaskWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId);
    void deteleTaskWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId);
}
