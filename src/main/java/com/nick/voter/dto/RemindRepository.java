package com.nick.voter.dto;


import com.nick.voter.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemindRepository extends JpaRepository<Quiz, Long> {

}
