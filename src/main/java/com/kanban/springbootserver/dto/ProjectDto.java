package com.kanban.springbootserver.dto;

import java.time.ZonedDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private ZonedDateTime dateCreated;
    private AccountDto account;
}
