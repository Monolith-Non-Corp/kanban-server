package com.kanban.springbootserver.entity;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(indexes = @Index(columnList = "authId"))
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String authId;

    @Column
    private String pictureUrl;

    @Column
    private String displayName;

    @Column
    private String username;
    
    @Column
    private String email;

    @Column(nullable = false)
    private ZonedDateTime lastActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    @OrderBy("dateCreated DESC")
    private List<Task> tasks = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    @OrderBy("dateCreated DESC")
    private List<Project> projects = new LinkedList<>();
}
