package com.kanban.springbootserver.controller;

import java.util.List;
import java.util.Optional;

import com.kanban.springbootserver.dao.repository.ProjectService;
import com.kanban.springbootserver.dto.ProjectDto;
import com.kanban.springbootserver.dto.ProjectWithBoardWithTaskDto;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Project;
import com.kanban.springbootserver.spring.AuthAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private MapperFacade mapperFacade;

    @GetMapping
    public List<ProjectWithBoardWithTaskDto> get(@AuthAccount Account principal) {
        List<Project> projects = projectService.getProjectsForAccount(principal);
        return mapperFacade.mapAsList(projects, ProjectWithBoardWithTaskDto.class);
    }

    @GetMapping("{projectId}")
    public ProjectWithBoardWithTaskDto get(@AuthAccount Account principal, @PathVariable Long projectId) {
        Optional<Project> projectOptional = projectService.getProjectWithIdForAccount(principal, projectId);
        return projectOptional.map(project -> mapperFacade.map(project, ProjectWithBoardWithTaskDto.class)).orElse(null);
    }

    @PostMapping
    public ProjectWithBoardWithTaskDto post(@AuthAccount Account principal, @RequestBody ProjectDto projectDto) {
        Project project = mapperFacade.map(projectDto, Project.class);
        return mapperFacade.map(projectService.saveProjectForAccount(principal, project), ProjectWithBoardWithTaskDto.class);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<?> delete(@AuthAccount Account principal, @PathVariable Long projectId) {
        projectService.deleteProjectWithIdFromAccount(principal, projectId);
        return ResponseEntity.ok().build();
    }
}
