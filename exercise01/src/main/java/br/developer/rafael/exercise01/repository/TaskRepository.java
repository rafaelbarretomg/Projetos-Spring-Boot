package br.developer.rafael.exercise01.repository;

import br.developer.rafael.exercise01.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
