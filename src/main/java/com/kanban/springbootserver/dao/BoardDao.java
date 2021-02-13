package com.kanban.springbootserver.dao;

import com.kanban.springbootserver.entity.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao extends JpaRepository<Board, Long> {
    
}
