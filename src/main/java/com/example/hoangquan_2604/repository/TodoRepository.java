package com.example.hoangquan_2604.repository;

import com.example.hoangquan_2604.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByIdDesc();
}
