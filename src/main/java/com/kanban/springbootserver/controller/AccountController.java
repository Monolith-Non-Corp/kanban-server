package com.kanban.springbootserver.controller;

import com.kanban.springbootserver.dto.AccountDto;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.spring.AuthAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("profile")
@CrossOrigin
public class AccountController {
    
    @Autowired
    private MapperFacade mapperFacade;
    
    @GetMapping
    public AccountDto info(@AuthAccount Account principal) {
        return mapperFacade.map(principal, AccountDto.class);
    }
}
