package com.kanban.springbootserver.dao.repository;

import java.util.List;
import java.util.Optional;

import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Project;

public interface ProjectService {
    List<Project> getProjectsForAccount(Account account);
    Project saveProjectForAccount(Account account, Project project);
    void deleteProjectWithIdFromAccount(Account account, Long projectId);
    Optional<Project> getProjectWithIdForAccount(Account account, Long projectId);
}
