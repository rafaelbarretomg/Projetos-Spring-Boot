package  challenges.challenge02_todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import  challenges.challenge02_todolist.models.Todolist;


public interface TodolistRepository extends JpaRepository<Todolist, Long>{
    
}
