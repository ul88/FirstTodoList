package com.todolistdev.todoList3.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUserId(String userId);
}
