package com.kanban.springbootserver.dao;

import com.kanban.springbootserver.entity.Property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDao extends JpaRepository<Property, Long> {
    
}
