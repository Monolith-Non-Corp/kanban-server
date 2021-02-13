package com.kanban.springbootserver.dao.repository.impl;

import java.util.Optional;

import com.kanban.springbootserver.dao.PropertyDao;
import com.kanban.springbootserver.dao.repository.PropertyService;
import com.kanban.springbootserver.dao.repository.TaskService;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Property;
import com.kanban.springbootserver.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyDao propertyDao;
    @Autowired
    private TaskService taskService;

    @Override
    public Property savePropertyOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId, Property property) {
        Optional<Task> taskOptional = taskService.getTaskWithIdOnPathWithAccount(account, projectId, boardId, taskId);
        return taskOptional.map(task -> {
            property.setTask(task);
            return propertyDao.save(property);
        }).orElse(null);
    }

    @Override
    public void detelePropertyWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId, Long propertyId) {
        Optional<Property> propertyOptional = propertyDao.findById(propertyId);
        propertyOptional.ifPresent(propertyDao::delete);
    }
}
