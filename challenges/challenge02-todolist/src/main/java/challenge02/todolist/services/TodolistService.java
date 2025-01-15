package challenge02.todolist.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge02.todolist.models.Todolist;
import challenge02.todolist.models.enums.ToDoStatus;
import challenge02.todolist.repositories.TodolistRepository;

@Service
public class TodolistService {
    
    @Autowired
    private TodolistRepository repository;

    public List<Todolist> findAll(){
        return repository.findAll();
    }

    public Todolist findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa nao encontrado"));
    }

    public Todolist insert(Todolist toDoList){
        try{
            if(toDoList.getStatus() == null){
                toDoList.setStatus(ToDoStatus.PENDENTE);
            }
            return repository.save(toDoList);
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir uma Tarefas", e);
        }
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Todolist update(Long id, Todolist todolist){
        try{
            Todolist entity = repository.getReferenceById(id);
            updateData(entity, todolist);
            return repository.save(entity);
        }catch(Exception e){
            throw new RuntimeException("Erro ao atualizar uma tarefa", e);
        }
    }

    private void updateData(Todolist todoList, Todolist obj ){
        todoList.setTitle(obj.getTitle());
        todoList.setDescription(obj.getDescription());
        todoList.setStatus(obj.getStatus());
        todoList.getCreationDate();
        if(todoList.getStatus() == ToDoStatus.CONCLUIDA){
            todoList.setConclusionDate(LocalDateTime.now());
        }
       
    }
}
