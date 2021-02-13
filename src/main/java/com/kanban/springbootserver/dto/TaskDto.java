package com.kanban.springbootserver.dto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TaskDto {
    private Long id;
    private String body;
    private ZonedDateTime dateCreated;
    private ZonedDateTime lastUpdated;
    private List<PropertyDto> properties = new ArrayList<>();
    private AccountDto account;
}
