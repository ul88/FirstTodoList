package com.todolistdev.todoList3.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoBoardRepository extends JpaRepository<TodoBoard, Long> {
    TodoBoard findByUserId(String userId);
}
