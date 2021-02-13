package com.kanban.springbootserver.dao;

import java.util.Optional;

import com.kanban.springbootserver.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

    Optional<Account> findByAuthId(String authId);
}
