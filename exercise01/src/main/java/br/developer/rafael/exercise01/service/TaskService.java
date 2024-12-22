package br.developer.rafael.exercise01.service;

import br.developer.rafael.exercise01.model.Task;
import br.developer.rafael.exercise01.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task save(Task task){
        return repository.save(task);
    }

    public Task update(Task task){
        if(task.getId() == null){
            throw new IllegalArgumentException("to update, is necessary that task exists");
        }
        return repository.save(task);
    }

    public void deletar(Task task){
        repository.delete(task);
    }
}
