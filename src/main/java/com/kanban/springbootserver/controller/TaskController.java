package com.kanban.springbootserver.controller;

import com.kanban.springbootserver.dao.repository.TaskService;
import com.kanban.springbootserver.dto.TaskDto;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Task;
import com.kanban.springbootserver.spring.AuthAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("projects/{projectId}/boards/{boardId}/tasks")
@CrossOrigin
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    @Autowired
    private MapperFacade mapperFacade;

    @PostMapping
    public TaskDto put(@AuthAccount Account account, @PathVariable Long projectId, @PathVariable Long boardId, @RequestBody TaskDto taskDto) {
        Task task = mapperFacade.map(taskDto, Task.class);
        return mapperFacade.map(taskService.saveTaskOnPathWithAccount(account, projectId, boardId, task), TaskDto.class);
    }

    @PatchMapping("{taskId}")
    public TaskDto update(@AuthAccount Account account, @PathVariable Long projectId, @PathVariable Long boardId, @PathVariable Long taskId) {
        return mapperFacade.map(taskService.updateTaskWithIdOnPathWithAccount(account, projectId, boardId, taskId), TaskDto.class);
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<?> delete(@AuthAccount Account account, @PathVariable Long projectId, @PathVariable Long boardId, @PathVariable Long taskId) {
        taskService.deteleTaskWithIdOnPathWithAccount(account, projectId, boardId, taskId);
        return ResponseEntity.ok().build();
    }
}
