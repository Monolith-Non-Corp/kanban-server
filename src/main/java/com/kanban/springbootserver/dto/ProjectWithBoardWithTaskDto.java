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
public class ProjectWithBoardWithTaskDto {
    private Long id;
    private String title;
    private String description;
    private ZonedDateTime dateCreated;
    private AccountDto account;
    private List<BoardWithTaskDto> boards = new ArrayList<>();
}
