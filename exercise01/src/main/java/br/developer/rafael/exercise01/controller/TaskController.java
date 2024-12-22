package br.developer.rafael.exercise01.controller;

import br.developer.rafael.exercise01.model.Task;
import br.developer.rafael.exercise01.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        List<Task> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Task task) {
        service.save(task);
        return ResponseEntity.ok().build();
    }


}
