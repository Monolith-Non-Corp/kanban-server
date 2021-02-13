package com.kanban.springbootserver.dao.repository;

import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Property;

public interface PropertyService {
    Property savePropertyOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId, Property property);
    void detelePropertyWithIdOnPathWithAccount(Account account, Long projectId, Long boardId, Long taskId, Long propertyId);
}
