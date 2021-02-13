package com.kanban.springbootserver.controller;

import com.kanban.springbootserver.dao.repository.PropertyService;
import com.kanban.springbootserver.dto.PropertyDto;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Property;
import com.kanban.springbootserver.spring.AuthAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("projects/{projectId}/boards/{boardId}/tasks/{taskId}/properties")
@CrossOrigin
public class PropertyController {
    
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private MapperFacade mapperFacade;

    @PostMapping
    public PropertyDto post(@AuthAccount Account account, @PathVariable Long projectId, @PathVariable Long boardId, @PathVariable Long taskId, @RequestBody PropertyDto propertyDto) {
        Property property = mapperFacade.map(propertyDto, Property.class);
        return mapperFacade.map(propertyService.savePropertyOnPathWithAccount(account, projectId, boardId, taskId, property), PropertyDto.class);
    }

    @DeleteMapping("{propertyId}")
    public ResponseEntity<?> delete(@AuthAccount Account account, @PathVariable Long projectId, @PathVariable Long boardId, @PathVariable Long taskId, @PathVariable Long propertyId) {
        propertyService.detelePropertyWithIdOnPathWithAccount(account, projectId, boardId, taskId, propertyId);
        return ResponseEntity.ok().build();
    }
}
