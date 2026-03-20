package com.example.hoangquan_2604.service;

import com.example.hoangquan_2604.model.Todo;
import com.example.hoangquan_2604.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByIdDesc();
    }

    public Todo save(String title) {
        Todo todo = new Todo(title);
        return todoRepository.save(todo);
    }

    public void complete(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(true);
        todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
