package  challenges.challenge02_todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import  challenges.challenge02_todolist.models.Todolist;
import  challenges.challenge02_todolist.services.TodolistService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/tarefas")
public class TodolistController {
    
    @Autowired
    private TodolistService service;

    @GetMapping
    public ResponseEntity<List<Todolist>> findAll() {
        List<Todolist> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todolist> findById(@PathVariable Long id) {
        Todolist toDoList = service.findById(id);
        return ResponseEntity.ok().body(toDoList);
    }

    @PostMapping
    public ResponseEntity<Todolist> insert(@RequestBody @Valid Todolist toDoList, BindingResult result) {
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        service.insert(toDoList);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todolist> update(@PathVariable Long id, @RequestBody @Valid Todolist toDoList, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        service.update(id, toDoList);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(toDoList);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
