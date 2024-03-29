package com.todolistdev.todoList3.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoBoardRepository extends JpaRepository<TodoBoard, Long> {
    List<TodoBoard> findByUserId(String userId);
}
