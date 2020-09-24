package com.htc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.model.Todolist;

@Repository
public interface TodolistRepository extends JpaRepository <Todolist, Long> {

}
