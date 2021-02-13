package com.kanban.springbootserver.dao;

import java.util.List;

import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {
    
    List<Project> findAllByAccountOrderByDateCreated(Account account);
}
