package challenge02.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import challenge02.todolist.models.Todolist;


public interface TodolistRepository extends JpaRepository<Todolist, Long>{
    
}
