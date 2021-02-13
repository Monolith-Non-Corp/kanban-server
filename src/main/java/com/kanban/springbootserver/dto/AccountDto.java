package com.kanban.springbootserver.dto;

import java.time.ZonedDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class AccountDto {
    private Long id;
    private String authId;
    private String pictureUrl;
    private String displayName;
    private String username;
    private String email;
    private ZonedDateTime lastActive;
}
