package com.kanban.springbootserver.controller;

import com.kanban.springbootserver.dao.repository.BoardService;
import com.kanban.springbootserver.dto.BoardDto;
import com.kanban.springbootserver.dto.BoardWithTaskDto;
import com.kanban.springbootserver.entity.Account;
import com.kanban.springbootserver.entity.Board;
import com.kanban.springbootserver.spring.AuthAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("projects/{projectId}/boards")
@CrossOrigin
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private MapperFacade mapperFacade;

    @PostMapping
    public BoardWithTaskDto post(@AuthAccount Account account, @PathVariable Long projectId, @RequestBody BoardDto boardDto) {
        Board board = mapperFacade.map(boardDto, Board.class);
        return mapperFacade.map(boardService.saveBoardOnPathWithAccount(account, projectId, board), BoardWithTaskDto.class);
    }

    @DeleteMapping("{boardId}")
    public ResponseEntity<?> delete(@AuthAccount Account account, @PathVariable Long projectId, @PathVariable Long boardId) {
        boardService.deleteBoardWithIdOnPathWithAccount(account, projectId, boardId);
        return ResponseEntity.ok().build();
    }
}
