package com.kanban.springbootserver.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class BoardWithTaskDto {
    private Long id;
    private String title;
    private List<TaskDto> tasks = new ArrayList<>();
}
