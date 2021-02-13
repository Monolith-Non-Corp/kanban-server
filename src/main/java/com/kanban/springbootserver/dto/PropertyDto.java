package com.kanban.springbootserver.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class PropertyDto {
    private Long id;
    private String title;
    private String color;
}
