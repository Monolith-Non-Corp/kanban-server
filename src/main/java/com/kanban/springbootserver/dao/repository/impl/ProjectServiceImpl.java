package com.kanban.springbootserver.dao.repository.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import com.kanban.springbootserver.dao.ProjectDao;
import com.kanban.springbootserver.dao.repository.ProjectService;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getProjectsForAccount(Account account) {
        return account.getProjects();
    }

    @Override
    public Project saveProjectForAccount(Account account, Project project) throws NullPointerException {
        project.setAccount(account);
        project.setDateCreated(ZonedDateTime.now());
        return projectDao.save(project);
    }

    @Override
    public void deleteProjectWithIdFromAccount(Account account, Long projectId) {
        Optional<Project> optionProject = projectDao.findById(projectId);
        optionProject.ifPresent(projectDao::delete);
    }

    @Override
    public Optional<Project> getProjectWithIdForAccount(Account account, Long projectId) {
        return projectDao.findById(projectId);
    }
}
