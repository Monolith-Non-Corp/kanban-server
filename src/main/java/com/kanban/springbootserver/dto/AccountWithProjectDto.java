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
public class AccountWithProjectDto {
    private Long id;
    private String authId;
    private String pictureUrl;
    private String username;
    private String email;
    private ZonedDateTime lastActive;
    private List<ProjectDto> projects = new ArrayList<>();
}
