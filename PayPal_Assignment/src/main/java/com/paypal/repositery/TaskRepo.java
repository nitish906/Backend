package com.paypal.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}
